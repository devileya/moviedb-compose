package com.arif.moviedbcompose.data.mappers

import com.arif.moviedbcompose.data.local.movie.MovieEntity
import com.arif.moviedbcompose.data.remote.response.MovieDto
import com.arif.moviedbcompose.domain.model.Movie

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 13 February 2024
 */
fun MovieDto.toMovieEntity(
    category: String
): MovieEntity {
    return MovieEntity(
        adult = adult ?: false,
        backdropPath = backdropPath ?: "",
        originalLanguage = originalLanguage ?: "",
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        releaseDate = releaseDate ?: "",
        title = title ?: "",
        voteAverage = voteAverage ?: 0.0,
        popularity = popularity ?: 0.0,
        voteCount = voteCount ?: 0,
        id = id ?: -1,
        originalTitle = originalTitle ?: "",
        video = video ?: false,

        category = category,

        genreIds = try {
            genreIds?.joinToString(",") ?: "-1,-2"
        } catch (e: Exception) {
            "-1,-2"
        }
    )
}

fun MovieEntity.toMovie(
    category: String
): Movie {
    return Movie(
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        id = id,
        adult = adult,
        originalTitle = originalTitle,
        category = category,
        genreIds = try {
            genreIds.split(",").map { it.toInt() }
        } catch (e: Exception) {
            listOf(-1, -2)
        }
    )
}