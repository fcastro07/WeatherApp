package com.example.weatherapp.data.network

import com.example.weatherapp.data.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class  OpenWeatherMapService @Inject constructor(private val api : OpenWeatherMapApiClient) {

    suspend fun getWeather(lat: Double, lon: Double) : WeatherModel? {
        return withContext(Dispatchers.IO) {
            val response = api.getWeather(lat, lon)
            response.body()
        }
    }
}