package com.melchikov.weatherapiapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorMessage(error: String?, modifier: Modifier = Modifier) {
    error?.let {
        Text(
            text = it,
            color = MaterialTheme.colorScheme.error,
            modifier = modifier.padding(vertical = 8.dp)
        )
    }
}