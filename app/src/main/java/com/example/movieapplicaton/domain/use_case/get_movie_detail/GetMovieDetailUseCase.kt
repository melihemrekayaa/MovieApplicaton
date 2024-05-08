package com.example.movieapplicaton.domain.use_case.get_movie_detail

import coil.network.HttpException
import com.example.movieapplicaton.data.remote.dto.toMovieDetail
import com.example.movieapplicaton.data.remote.dto.toMovieList
import com.example.movieapplicaton.domain.model.Movie
import com.example.movieapplicaton.domain.model.MovieDetail
import com.example.movieapplicaton.domain.repository.MovieRepository
import com.example.movieapplicaton.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(val repository : MovieRepository){
    fun executeGetMovieDetails(imdbId : String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }
        catch (e: IOError){
            emit(Resource.Error(message = "Check your internet connection"))
        }

        catch (e: HttpException){
            emit(Resource.Error(message = "An unexpected error occurred"))
        }

        catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }

    }
}