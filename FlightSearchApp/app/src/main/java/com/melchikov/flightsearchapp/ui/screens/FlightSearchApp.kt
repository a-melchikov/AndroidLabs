package com.melchikov.flightsearchapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.melchikov.flightsearchapp.ui.viewmodels.FlightViewModel

@Composable
fun FlightSearchApp(viewModel: FlightViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "search"
    ) {
        composable("search") {
            SearchScreen(
                viewModel = viewModel,
                onAirportSelected = { airport ->
                    viewModel.selectAirport(airport)
                    viewModel.generateFlightsForAirport(airport)
                    navController.navigate("flights")
                }
            )
        }
        composable("flights") {
            FlightListScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
