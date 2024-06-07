package com.arif.moviedbcompose.domain.repository

import com.arif.moviedbcompose.domain.model.Movie
import com.arif.moviedbcompose.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 13 February 2024
 */
interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int): Flow<Resource<Movie>>
}