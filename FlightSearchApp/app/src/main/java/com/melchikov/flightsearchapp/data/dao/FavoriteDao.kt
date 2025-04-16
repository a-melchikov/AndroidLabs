package com.melchikov.flightsearchapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.melchikov.flightsearchapp.data.model.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: Favorite)

    @Query("DELETE FROM favorite WHERE departure_code = :departure AND destination_code = :destination")
    suspend fun delete(departure: String, destination: String)

    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): Flow<List<Favorite>>
}