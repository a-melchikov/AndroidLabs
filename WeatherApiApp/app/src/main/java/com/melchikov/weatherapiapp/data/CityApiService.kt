package com.melchikov.weatherapiapp.data

import com.melchikov.weatherapiapp.model.CityResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApiService {
    @GET("city")
    suspend fun getCityInfo(@Query("name") name: String): List<CityResponse>
}