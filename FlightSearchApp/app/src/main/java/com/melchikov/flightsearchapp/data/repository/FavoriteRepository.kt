package com.melchikov.flightsearchapp.data.repository

import com.melchikov.flightsearchapp.data.dao.FavoriteDao
import com.melchikov.flightsearchapp.data.model.Favorite
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val favoriteDao: FavoriteDao) {
    fun getFavorites(): Flow<List<Favorite>> = favoriteDao.getAllFavorites()

    suspend fun insertFavorite(favorite: Favorite) = favoriteDao.insert(favorite)

    suspend fun removeFavorite(departure: String, destination: String) =
        favoriteDao.delete(departure, destination)
}