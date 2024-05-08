package com.example.movieapplicaton.data.repository

import com.example.movieapplicaton.data.remote.dto.MovieDetailDto
import com.example.movieapplicaton.data.remote.dto.MoviesAPI
import com.example.movieapplicaton.data.remote.dto.MoviesDto
import com.example.movieapplicaton.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api : MoviesAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }

}