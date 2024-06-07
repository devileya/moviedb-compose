package com.arif.moviedbcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arif.moviedbcompose.presentation.MovieListViewModel
import com.arif.moviedbcompose.ui.theme.MovieDbComposeTheme
import com.arif.moviedbcompose.util.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 15 February 2024
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieDbComposeTheme {
                SetBarColor(color = MaterialTheme.colorScheme.inverseOnSurface)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    val movieListViewModel = hiltViewModel<MovieListViewModel>()

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "movie_list_screen",
                    ) {
                        composable(Screen.Home.route) {
                            HomeScreen(navController)
                        }
                        composable(
                            Screen.Details.route+"/{movie_id}",
                            arguments = listOf(navArgument("movie_id") { type = NavType.IntType })
                            ) {backStackEntry ->
                            HomeScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SetBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = color) {
        systemUiController.setStatusBarColor(color = color)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieDbComposeTheme {
        Greeting("Android")
    }
}