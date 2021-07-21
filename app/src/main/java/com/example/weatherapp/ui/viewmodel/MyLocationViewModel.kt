package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.OpenWeatherMapRepository
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.model.WeatherProvider
import kotlinx.coroutines.launch

class MyLocationViewModel : ViewModel() {

    private val repository = OpenWeatherMapRepository()

    val weatherModel = MutableLiveData<WeatherModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun updateWeather(lat: Double, lon: Double, forceUpdate: Boolean = false) {
        isLoading.postValue(true)
        if (!forceUpdate && WeatherProvider.lastMyLocationWeather != null) {
            weatherModel.postValue(WeatherProvider.lastMyLocationWeather)
            isLoading.postValue(false)
            return
        }

        viewModelScope.launch {
            val result = repository.getWeather(lat, lon)
            if (result != null) {
                weatherModel.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }
}