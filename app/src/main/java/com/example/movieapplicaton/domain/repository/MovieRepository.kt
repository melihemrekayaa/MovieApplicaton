package com.example.movieapplicaton.domain.repository

import com.example.movieapplicaton.data.remote.dto.MovieDetailDto
import com.example.movieapplicaton.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}