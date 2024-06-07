package com.arif.moviedbcompose.util

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 13 February 2024
 */
sealed class Screen(val route: String) {
    data object Home: Screen("main")
    data object PopularMovieList: Screen("popularMovie")
    data object UpcomingMovieList: Screen("upcomingMovie")
    data object Details: Screen("details")
}