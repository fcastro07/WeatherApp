package com.example.weatherapp.data.model

data class WeatherModel(
    val dt: Double,
    val current: CurrentWeatherModel,
    val daily: MutableList<DailyWeatherModel>,
    val timezone: String,
    val timezone_offset: Int
)