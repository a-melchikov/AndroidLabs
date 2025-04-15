package com.melchikov.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.melchikov.mycityapp.ui.screens.*
import com.melchikov.mycityapp.ui.theme.MyCityAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            HomeScreen(navController = navController)
                        }
                        composable("category/{categoryId}") { backStackEntry ->
                            val categoryId =
                                backStackEntry.arguments?.getString("categoryId")?.toIntOrNull()
                                    ?: 0
                            CategoryScreen(
                                navController = navController,
                                categoryId = categoryId
                            )
                        }
                        composable("detail/{recommendationId}") { backStackEntry ->
                            val recommendationId =
                                backStackEntry.arguments?.getString("recommendationId")
                                    ?.toIntOrNull() ?: 0
                            DetailScreen(
                                navController = navController,
                                recommendationId = recommendationId
                            )
                        }
                    }
                }
            }
        }
    }
}