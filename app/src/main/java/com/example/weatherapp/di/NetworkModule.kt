package com.example.weatherapp.di

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.network.OpenWeatherMapApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain -> this.addApiKeyToRequests(chain) }
            .build()
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideOpenWeatherMapApiClient(retrofit: Retrofit) : OpenWeatherMapApiClient {
        return retrofit.create(OpenWeatherMapApiClient::class.java)
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