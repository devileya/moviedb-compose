package com.arif.moviedbcompose.presentation

import com.arif.moviedbcompose.domain.model.Movie

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 15 February 2024
 */
data class MovieListState(
    val isLoading: Boolean = false,
    val popularMovieListPage: Int = 1,
    val upcomingMovieListPage: Int = 1,
    val isCurrentPopularScreen: Boolean = true,
    val popularMovieList: List<Movie> = emptyList(),
    val upcomingMovieList: List<Movie> = emptyList()
)