package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.domain.GetWeather
import kotlinx.coroutines.launch

class MyLocationViewModel : ViewModel() {

    val weatherModel = MutableLiveData<WeatherModel>()
    private val getWeather = GetWeather()

    fun updateWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            val result = getWeather(lat, lon)
            if (result != null) {
                weatherModel.postValue(result!!)
            }
        }
    }
}