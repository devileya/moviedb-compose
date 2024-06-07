package com.arif.moviedbcompose.presentation

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 15 February 2024
 */
sealed interface MovieListUiEvent {
    data class Paginate(val category: String): MovieListUiEvent
    object Navigate: MovieListUiEvent
}