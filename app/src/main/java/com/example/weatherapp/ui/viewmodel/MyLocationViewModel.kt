package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.domain.GetWeatherInMyLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyLocationViewModel @Inject constructor(
    private val getWeatherInMyLocation : GetWeatherInMyLocation
) : ViewModel() {

    private val _weather = MutableLiveData<WeatherModel>()
    val weather: LiveData<WeatherModel> = _weather

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun updateWeather(lat: Double, lon: Double, forceUpdate: Boolean = false) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val result = getWeatherInMyLocation(lat, lon, forceUpdate)
            result?.also {
                _weather.postValue(it)
                _isLoading.postValue(false)
            }
        }
    }
}