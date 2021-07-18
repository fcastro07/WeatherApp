package com.example.weatherapp.data.network

import com.example.weatherapp.core.RetrofitHelper
import com.example.weatherapp.data.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class  OpenWeatherMapService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getWeather(lat: Double, lon: Double) : WeatherModel? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(OpenWeatherMapApiClient::class.java)
                .getWeather(lat, lon)
            response.body()
        }
    }
}