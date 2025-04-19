package com.melchikov.weatherapiapp.model

import kotlinx.serialization.Serializable

@Serializable
data class CityResponse(
    val name: String,
    val latitude: Double,
    val longitude: Double
)