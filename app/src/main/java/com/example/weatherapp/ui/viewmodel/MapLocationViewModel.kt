package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.OpenWeatherMapRepository
import com.example.weatherapp.data.model.WeatherModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

class MapLocationViewModel : ViewModel() {

    private val repository = OpenWeatherMapRepository()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _weather = MutableLiveData<WeatherModel>()
    val weather: LiveData<WeatherModel> = _weather

    private val _location = MutableLiveData<LatLng>()
    val location: LiveData<LatLng> = _location


    fun updateWeather(lat: Double, lon: Double) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val result = repository.getWeather(lat, lon)
            if (result != null) {
                _location.postValue(LatLng(lat, lon))
                _weather.postValue(result!!)
                _isLoading.postValue(false)
            }
        }
    }
}