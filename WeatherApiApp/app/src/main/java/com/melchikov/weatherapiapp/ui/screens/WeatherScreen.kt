package com.melchikov.weatherapiapp.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.melchikov.weatherapiapp.ui.viewmodels.WeatherViewModel
import com.melchikov.weatherapiapp.ui.components.CityDropdown
import com.melchikov.weatherapiapp.ui.components.ErrorMessage
import com.melchikov.weatherapiapp.ui.components.WeatherList


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val cities by viewModel.cities.collectAsState()
    val weather by viewModel.weather.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        CityDropdown(
            cities = cities,
            onCitySelected = { viewModel.loadWeather(it.latitude, it.longitude) },
            onLoadCities = { viewModel.loadCity(it) }
        )
        ErrorMessage(error)
        WeatherList(weather = weather)
    }
}
