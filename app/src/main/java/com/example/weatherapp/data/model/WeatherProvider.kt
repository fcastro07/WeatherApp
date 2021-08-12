package com.example.weatherapp.data.model

import javax.inject.Inject

class WeatherProvider @Inject constructor() {
    var lastMyLocationWeather:WeatherModel? = null
}