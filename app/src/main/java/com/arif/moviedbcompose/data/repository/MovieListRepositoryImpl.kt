package com.arif.moviedbcompose.data.repository

import com.arif.moviedbcompose.data.local.movie.MovieDatabase
import com.arif.moviedbcompose.data.mappers.toMovie
import com.arif.moviedbcompose.data.mappers.toMovieEntity
import com.arif.moviedbcompose.data.remote.MovieApi
import com.arif.moviedbcompose.domain.model.Movie
import com.arif.moviedbcompose.domain.repository.MovieListRepository
import com.arif.moviedbcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 13 February 2024
 */
class MovieListRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : MovieListRepository {

    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> = flow {

            emit(Resource.Loading(true))

            val localMovieList = movieDatabase.movieDao.getMovieListByCategory(category)

            val shouldLoadLocalMovie = localMovieList.isNotEmpty() && !forceFetchFromRemote

            if (shouldLoadLocalMovie) {
                emit(Resource.Success(
                    data = localMovieList.map { movieEntity ->
                        movieEntity.toMovie(category)
                    }
                ))

                emit(Resource.Loading(false))
                return@flow
            }

            val movieListFromApi = try {
                movieApi.getMoviesList(category, page)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            }

            val movieEntities = movieListFromApi.results.let {
                it.map { movieDto ->
                    movieDto.toMovieEntity(category)
                }
            }

            movieDatabase.movieDao.upsertMovieList(movieEntities)

            emit(Resource.Success(
                movieEntities.map { it.toMovie(category) }
            ))
            emit(Resource.Loading(false))

    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> = flow {

            emit(Resource.Loading(true))

            val movieEntity = movieDatabase.movieDao.getMovieById(id)

            emit(Resource.Success(movieEntity.toMovie(movieEntity.category)))

            emit(Resource.Loading(false))
    }.catch {
        emit(Resource.Error("Error no such movie"))
        emit(Resource.Loading(false))
    }
}