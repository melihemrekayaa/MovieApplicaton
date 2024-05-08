package com.example.movieapplicaton.presentation.movies

import com.example.movieapplicaton.domain.model.Movie

data class MovieState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String? = null,
    val search: String = "batman"
) {
}