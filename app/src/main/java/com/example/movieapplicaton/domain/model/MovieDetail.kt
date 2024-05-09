package com.example.movieapplicaton.domain.model

import com.example.movieapplicaton.data.remote.dto.Rating

data class MovieDetail(
    val Actors: String,
    val Awards: String,
    val Country: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Poster: String,
    val Rated: String,
    val Ratings: List<Rating>,
    val Released: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String,
    val imdbRating: String
)
