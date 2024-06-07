package com.arif.moviedbcompose.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 13 February 2024
 */
data class Movie(
    val adult: Boolean?,
    val backdropPath: String?,
    val genreIds: List<Int>?,
    val id: Int?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val category: String
)
