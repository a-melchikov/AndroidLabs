package com.melchikov.weatherapiapp.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherItem(time: String, temperature: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = formatTime(time),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "%.1f°C".format(temperature),
            modifier = Modifier.weight(1f)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun formatTime(timeString: String): String {
    return try {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val dateTime = LocalDateTime.parse(timeString, formatter)
        dateTime.format(DateTimeFormatter.ofPattern("HH:mm, d MMM"))
    } catch (e: Exception) {
        timeString
    }
}