package com.example.weatherapp.domain

import com.example.weatherapp.data.OpenWeatherMapRepository
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.model.WeatherProvider
import javax.inject.Inject

class GetWeatherInMyLocation @Inject constructor(
    private val repository : OpenWeatherMapRepository,
    private val weatherProvider : WeatherProvider
) {

    suspend operator fun invoke(lat: Double, lon: Double, forceUpdate: Boolean = false) : WeatherModel? {
        if (!forceUpdate && weatherProvider.lastMyLocationWeather != null) {
            return weatherProvider.lastMyLocationWeather
        }

        val result = repository.getWeather(lat, lon)
        result?.also {
            it.daily.removeAt(0)
            weatherProvider.lastMyLocationWeather = result
        }

        return result
    }
}