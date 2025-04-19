package com.melchikov.weatherapiapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.melchikov.weatherapiapp.model.CityResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDropdown(
    cities: List<CityResponse>,
    onCitySelected: (CityResponse) -> Unit,
    onLoadCities: (String) -> Unit
) {
    var selectedCity by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            value = selectedCity,
            onValueChange = {
                selectedCity = it
                onLoadCities(it)
            },
            label = { Text("Search city") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            cities.forEach { city ->
                DropdownMenuItem(
                    text = { Text(city.name) },
                    onClick = {
                        selectedCity = city.name
                        expanded = false
                        onCitySelected(city)
                    }
                )
            }
        }
    }
}