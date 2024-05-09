package com.example.movieapplicaton.presentation.movie_detail

import com.example.movieapplicaton.domain.model.Movie
import com.example.movieapplicaton.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail ?= null,
    val error: String = ""

) {
}