package com.example.movieapplicaton.domain.use_case.get_movies

import coil.network.HttpException
import com.example.movieapplicaton.data.remote.dto.toMovieList
import com.example.movieapplicaton.domain.model.Movie
import com.example.movieapplicaton.domain.repository.MovieRepository
import com.example.movieapplicaton.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError

import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>>  = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            }
            else{
                emit(Resource.Error(message = "No movies found"))
            }
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