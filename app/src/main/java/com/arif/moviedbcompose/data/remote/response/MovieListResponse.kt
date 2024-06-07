package com.arif.moviedbcompose.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)