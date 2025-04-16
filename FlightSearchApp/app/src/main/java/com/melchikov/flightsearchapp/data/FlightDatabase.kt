package com.melchikov.flightsearchapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.melchikov.flightsearchapp.data.dao.AirportDao
import com.melchikov.flightsearchapp.data.dao.FavoriteDao
import com.melchikov.flightsearchapp.data.model.Airport
import com.melchikov.flightsearchapp.data.model.Favorite

@Database(
    entities = [Airport::class, Favorite::class],
    version = 1,
    exportSchema = false
)
abstract class FlightDatabase : RoomDatabase() {
    abstract fun airportDao(): AirportDao
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: FlightDatabase? = null

        fun getDatabase(context: Context): FlightDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FlightDatabase::class.java,
                    "flight_search.db"
                )
                    .createFromAsset("flight_search.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}