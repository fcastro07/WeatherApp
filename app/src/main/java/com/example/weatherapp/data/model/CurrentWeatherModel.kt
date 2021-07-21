package com.example.weatherapp.data.model

data class CurrentWeatherModel(
    val feels_like: Double,
    val temp: Double,
    val weather: List<WeatherInfoModel>
)