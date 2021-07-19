package com.example.weatherapp.data

import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.model.WeatherProvider
import com.example.weatherapp.data.network.OpenWeatherMapService

class OpenWeatherMapRepository {
    private val api = OpenWeatherMapService()

    suspend fun getWeather(lat: Double, lon: Double) : WeatherModel? {
        val response = api.getWeather(lat, lon)
        WeatherProvider.weather = response
        return response
    }
}