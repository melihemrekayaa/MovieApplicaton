package com.example.movieapplicaton.presentation

sealed class Screen(val route: String) {
    object MovieScreen : Screen(route = "movie_screen")
    object MovieDetailScreen : Screen(route = "movie_detail_screen")
}