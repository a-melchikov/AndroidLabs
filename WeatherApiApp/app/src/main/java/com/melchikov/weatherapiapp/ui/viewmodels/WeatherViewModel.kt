package com.melchikov.weatherapiapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melchikov.weatherapiapp.model.CityResponse
import com.melchikov.weatherapiapp.model.WeatherResponse
import com.melchikov.weatherapiapp.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _cities = MutableStateFlow<List<CityResponse>>(emptyList())
    val cities: StateFlow<List<CityResponse>> = _cities

    private val _weather = MutableStateFlow<WeatherResponse?>(null)
    val weather: StateFlow<WeatherResponse?> = _weather

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadCity(cityName: String) {
        viewModelScope.launch {
            try {
                _cities.value = repository.getCities(cityName)
                _error.value = null
            } catch (e: Exception) {
                _error.value = "City error: ${e.message}"
            }
        }
    }

    fun loadWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            try {
                _weather.value = repository.getWeather(latitude, longitude)
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Weather error: ${e.message}"
            }
        }
    }
}
