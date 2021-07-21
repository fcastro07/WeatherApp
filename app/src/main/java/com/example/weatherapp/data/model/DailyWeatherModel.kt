package com.example.weatherapp.data.model

data class DailyWeatherModel(
    val dt: Long,
    val temp: DailyTemperatureModel,
    val weather: List<WeatherInfoModel>
)