package com.melchikov.weatherapiapp.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object ApiClient {
    private const val API_NINJAS_KEY = "MNdNWxVzXVXfgYKsGei01Q==R47fD3rrQCcLSYzN"
    private val json = Json { ignoreUnknownKeys = true }

    val cityApiService: CityApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(ApiKeyInterceptor(API_NINJAS_KEY))
                    .build()
            )
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(CityApiService::class.java)
    }

    val weatherApiService: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/v1/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(WeatherApiService::class.java)
    }
}