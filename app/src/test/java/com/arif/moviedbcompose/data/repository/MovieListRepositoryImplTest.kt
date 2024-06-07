package com.arif.moviedbcompose.data.repository

import com.arif.moviedbcompose.data.local.movie.MovieDatabase
import com.arif.moviedbcompose.data.local.movie.MovieEntity
import com.arif.moviedbcompose.data.mappers.toMovie
import com.arif.moviedbcompose.data.remote.MovieApi
import com.arif.moviedbcompose.util.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 15 February 2024
 */
class MovieListRepositoryImplTest {
    private val movieApi: MovieApi = mockk()
    private val movieDatabase: MovieDatabase = mockk()
    private val repository = MovieListRepositoryImpl(movieApi, movieDatabase)

    @Test
    fun `getMovieList returns data from local database when available`() {
        val category = "popular"
        val localMovieList = listOf(
            MovieEntity(
                id = 1,
                title = "Movie 1",
                category = category,
                adult = true,
                video = true,
                voteCount = 1,
                voteAverage = 1.0,
                popularity = 1.0,
                originalLanguage = "en",
                originalTitle = "Movie 1",
                overview = "Overview 1",
                posterPath = "posterPath 1",
                releaseDate = "releaseDate 1",
                backdropPath = "backdropPath 1",
                genreIds = "1,2,3"
            ),
        )

        // Mock behavior of the local database to return local movie list
        coEvery { movieDatabase.movieDao.getMovieListByCategory(category) } returns localMovieList
        // Verify that the method is called once
        coVerify(exactly = 1) { movieDatabase.movieDao.getMovieListByCategory(category) }

        runTest {
            // Call the method under test
            val result = repository.getMovieList(forceFetchFromRemote = false, category, page = 1)

            // Verify that the emitted value is the local movie list
            result.collectLatest { resource ->

                // Logging
                println("Expected movie list: ${localMovieList.map { it.toMovie(category) }}")
                println("Actual movie list: ${resource.data}")

                assert(resource is Resource.Success)
                assertEquals(localMovieList.map { it.toMovie(category) }, resource.data)
            }
        }
    }
}