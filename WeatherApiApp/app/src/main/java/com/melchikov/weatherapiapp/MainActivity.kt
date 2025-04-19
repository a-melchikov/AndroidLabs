package com.melchikov.weatherapiapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.melchikov.weatherapiapp.data.WeatherViewModel
import com.melchikov.weatherapiapp.ui.screens.WeatherScreen
import com.melchikov.weatherapiapp.ui.theme.WeatherAppTheme


class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    WeatherScreen(viewModel)
                }
            }
        }
    }
}