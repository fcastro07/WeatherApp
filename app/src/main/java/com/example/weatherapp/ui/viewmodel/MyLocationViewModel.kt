package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.domain.GetWeather
import kotlinx.coroutines.launch

class MyLocationViewModel : ViewModel() {

    private val weatherModel = MutableLiveData<WeatherModel>()

    val getWeather = GetWeather()

    fun updateWeather() {
        viewModelScope.launch {
            val result = getWeather(33.44, -94.04)
            if (result != null) {
                weatherModel.postValue(result!!)
            }
        }
    }
}