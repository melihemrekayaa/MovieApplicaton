package com.example.movieapplicaton.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapplicaton.presentation.movie_detail.views.MovieDetailScreen
import com.example.movieapplicaton.presentation.movies.views.MovieScreen
import com.example.movieapplicaton.presentation.ui.theme.MovieApplicatonTheme
import com.example.movieapplicaton.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieApplicatonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                    {
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = Screen.MovieScreen.route) {
                            composable(route = Screen.MovieScreen.route) {
                                MovieScreen(navController = navController)
                            }

                            composable(route = Screen.MovieDetailScreen.route + "/{${IMDB_ID}}") {
                                MovieDetailScreen()
                            }
                        }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieApplicatonTheme {

    }
}