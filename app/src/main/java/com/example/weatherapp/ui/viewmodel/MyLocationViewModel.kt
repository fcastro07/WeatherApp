package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.OpenWeatherMapRepository
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.model.WeatherProvider
import kotlinx.coroutines.launch

class MyLocationViewModel : ViewModel() {

    private val repository = OpenWeatherMapRepository()

    private val _weather = MutableLiveData<WeatherModel>()
    val weather: LiveData<WeatherModel> = _weather

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun updateWeather(lat: Double, lon: Double, forceUpdate: Boolean = false) {
        _isLoading.postValue(true)
        if (!forceUpdate && WeatherProvider.lastMyLocationWeather != null) {
            _weather.postValue(WeatherProvider.lastMyLocationWeather)
            _isLoading.postValue(false)
            return
        }

        viewModelScope.launch {
            val result = repository.getWeather(lat, lon)
            if (result != null) {
                result.daily.removeAt(0)
                WeatherProvider.lastMyLocationWeather = result
                _weather.postValue(result!!)
                _isLoading.postValue(false)
            }
        }
    }
}