package com.example.movieapplicaton.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplicaton.domain.use_case.get_movies.GetMovieUseCase
import com.example.movieapplicaton.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MovieState())
    val state : State<MovieState> = _state

    private var job : Job ?= null

    init {
        getMovies(_state.value.search)
    }

    private fun getMovies(search: String) {
        job?.cancel()

        job = getMovieUseCase.executeGetMovies(search = search).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieState(movies = it.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _state.value = MovieState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = MovieState(error = it.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)

    }

    fun onEvent(event: MovieEvent){
        when(event) {
            is MovieEvent.Search -> {
                getMovies(event.searchString)
            }
        }
    }
}