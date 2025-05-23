package com.melchikov.flightsearchapp.data.repository

import com.melchikov.flightsearchapp.data.dao.AirportDao
import com.melchikov.flightsearchapp.data.model.Airport
import com.melchikov.flightsearchapp.data.model.Flight
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class AirportRepository(private val airportDao: AirportDao) {


    fun searchAirports(query: String): Flow<List<Airport>> {
        val formattedQuery = "%$query%"
        return airportDao.searchAirports(formattedQuery)
    }

    private suspend fun getAllAirports(): List<Airport> {
        return airportDao.getAll().first()
    }

    fun generateFlightsForAirports(): Flow<List<Flight>> = flow {
        val airports = getAllAirports()

        val flights = mutableListOf<Flight>()

        for (departureAirport in airports) {
            for (destinationAirport in airports) {
                if (departureAirport.id != destinationAirport.id) {
                    val flight = Flight(
                        departureCode = departureAirport.iataCode,
                        destinationCode = destinationAirport.iataCode
                    )
                    flights.add(flight)
                }
            }
        }
        emit(flights)
    }

}