package com.example.movieapplicaton.presentation.movies

sealed class MovieEvent {
    data class Search(val searchString : String) : MovieEvent()
}