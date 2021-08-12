package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.domain.GetWeatherOfLocation
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapLocationViewModel @Inject constructor(
    private val getWeatherOfLocation : GetWeatherOfLocation
) : ViewModel() {

    private val _weather = MutableLiveData<WeatherModel>()
    val weather: LiveData<WeatherModel> = _weather

    private val _location = MutableLiveData<LatLng>()
    val location: LiveData<LatLng> = _location

    fun updateWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            val result = getWeatherOfLocation(lat, lon)
            result?.also {
                _location.postValue(LatLng(lat, lon))
                _weather.postValue(it)
            }
        }
    }
}