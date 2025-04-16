package com.melchikov.flightsearchapp.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.melchikov.flightsearchapp.data.dao.AirportDao
import com.melchikov.flightsearchapp.data.dao.FavoriteDao
import com.melchikov.flightsearchapp.data.repository.AirportRepository
import com.melchikov.flightsearchapp.data.repository.SearchPreferencesRepository
import com.melchikov.flightsearchapp.data.repository.FavoriteRepository

class FlightViewModelFactory(
    private val airportDao: AirportDao,
    private val favoriteDao: FavoriteDao,
    private val searchPreferencesRepository: SearchPreferencesRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlightViewModel::class.java)) {
            val airportRepository = AirportRepository(airportDao)
            val favoriteRepository = FavoriteRepository(favoriteDao)
            return FlightViewModel(
                airportRepository,
                favoriteRepository,
                searchPreferencesRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}