package com.example.weatherapp.domain

import com.example.weatherapp.data.OpenWeatherMapRepository
import com.example.weatherapp.data.model.WeatherModel

class GetWeather {
    private val repository = OpenWeatherMapRepository()

    suspend operator fun invoke(lat: Double, lon: Double) : WeatherModel? {
        return repository.getWeather(lat, lon)
    }
}