package com.example.weatherapp.data.network

import com.example.weatherapp.data.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApiClient {
    @GET("onecall")
    suspend fun getWeather(@Query("lat")lat: Double, @Query("lon")lon: Double) : Response<WeatherModel>
}