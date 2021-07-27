package com.example.weatherapp.data

import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.network.OpenWeatherMapService

class OpenWeatherMapRepository {
    private val api = OpenWeatherMapService()

    suspend fun getWeather(lat: Double, lon: Double): WeatherModel? {
        return api.getWeather(lat, lon)
    }
}