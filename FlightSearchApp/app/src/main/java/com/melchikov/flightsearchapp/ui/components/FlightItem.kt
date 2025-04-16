package com.melchikov.flightsearchapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.melchikov.flightsearchapp.data.model.Flight

@Composable
fun FlightItem(
    flight: Flight,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "${flight.departureCode} → ${flight.destinationCode}",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Прямой рейс",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(onClick = onFavoriteClick) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = if (isFavorite) "Удалить из избранного" else "Добавить в избранное",
                    tint = if (isFavorite) Color.Red else MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}