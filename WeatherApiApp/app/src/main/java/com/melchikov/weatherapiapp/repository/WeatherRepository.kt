package com.melchikov.weatherapiapp.repository

import com.melchikov.weatherapiapp.data.CityApiService
import com.melchikov.weatherapiapp.data.WeatherApiService
import com.melchikov.weatherapiapp.model.CityResponse
import com.melchikov.weatherapiapp.model.WeatherResponse

class WeatherRepository(
    private val cityApi: CityApiService,
    private val weatherApi: WeatherApiService
) {
    suspend fun getCities(name: String): List<CityResponse> {
        return cityApi.getCityInfo(name)
    }

    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        return weatherApi.getWeather(lat, lon)
    }
}
