package com.example.movieapplicaton.data.remote.dto

import com.example.movieapplicaton.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto
}