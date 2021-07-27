package com.example.weatherapp.core

import com.example.weatherapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit() : Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain -> addApiKeyToRequests(chain) }
            .build()
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun addApiKeyToRequests(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url()
        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("appid", BuildConfig.OPENWEATHERMAP_API_KEY)
            .addQueryParameter("exclude", "minutely,hourly,alerts")
            .addQueryParameter("units", "metric")
            .build()
        request.url(newUrl)
        return chain.proceed(request.build())
    }
}