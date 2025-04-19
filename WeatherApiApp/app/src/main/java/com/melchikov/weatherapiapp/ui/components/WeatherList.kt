package com.melchikov.weatherapiapp.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.melchikov.weatherapiapp.model.WeatherResponse


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherList(weather: WeatherResponse?, modifier: Modifier = Modifier) {
    weather?.hourly?.let { hourly ->
        LazyColumn(modifier = modifier.padding(top = 16.dp)) {
            itemsIndexed(hourly.time) { index, time ->
                WeatherItem(
                    time = time,
                    temperature = hourly.temperature2m.getOrNull(index) ?: 0.0
                )
            }
        }
    }
}