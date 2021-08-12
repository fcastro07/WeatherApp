package com.example.weatherapp.data

import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.network.OpenWeatherMapService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OpenWeatherMapRepository @Inject constructor(private val api : OpenWeatherMapService) {
    suspend fun getWeather(lat: Double, lon: Double): WeatherModel? {
        return api.getWeather(lat, lon)
    }
}