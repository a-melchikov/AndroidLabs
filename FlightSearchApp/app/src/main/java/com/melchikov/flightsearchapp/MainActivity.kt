package com.melchikov.flightsearchapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.viewmodel.compose.viewModel
import com.melchikov.flightsearchapp.data.FlightDatabase
import com.melchikov.flightsearchapp.data.FlightViewModel
import com.melchikov.flightsearchapp.data.FlightViewModelFactory
import com.melchikov.flightsearchapp.data.repository.SearchPreferencesRepository
import com.melchikov.flightsearchapp.ui.screens.FlightSearchApp
import com.melchikov.flightsearchapp.ui.theme.FlightSearchAppTheme


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = FlightDatabase.getDatabase(this)
        val searchPreferences = SearchPreferencesRepository(dataStore)

        setContent {
            FlightSearchAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: FlightViewModel = viewModel(
                        factory = FlightViewModelFactory(
                            database.airportDao(),
                            database.favoriteDao(),
                            searchPreferences
                        )
                    )

                    FlightSearchApp(viewModel = viewModel)
                }
            }
        }
    }
}