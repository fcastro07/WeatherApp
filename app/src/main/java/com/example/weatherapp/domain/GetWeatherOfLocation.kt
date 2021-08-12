package com.example.weatherapp.domain

import com.example.weatherapp.data.OpenWeatherMapRepository
import com.example.weatherapp.data.model.WeatherModel
import javax.inject.Inject

class GetWeatherOfLocation @Inject constructor(private val repository : OpenWeatherMapRepository) {

    suspend operator fun invoke(lat: Double, lon: Double) : WeatherModel? {
        return repository.getWeather(lat, lon)
    }
}