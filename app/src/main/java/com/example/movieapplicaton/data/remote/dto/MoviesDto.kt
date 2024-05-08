package com.example.movieapplicaton.data.remote.dto

import com.example.movieapplicaton.domain.model.Movie

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MoviesDto.toMovieList(): List<Movie> {
    return Search.map {
        Movie(
            imdbID = it.imdbID,
            Poster = it.Poster,
            Title = it.Title,
            Year = it.Year)
    }
}

