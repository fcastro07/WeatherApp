package com.example.weatherapp.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.databinding.InfowindowWeatherBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker


class WeatherInfoWindowAdapter(
    private var context: Context,
    private var weather: WeatherModel
) : GoogleMap.InfoWindowAdapter {

    override fun getInfoWindow(marker: Marker): View? = null

    override fun getInfoContents(marker: Marker): View {
        val binding = InfowindowWeatherBinding.inflate(LayoutInflater.from(context), null, false)

        binding.currentDegrees.text = "${weather.current.temp.toInt()}°"
        binding.max.text = "↑${weather.daily[0].temp.max.toInt()}°"
        binding.min.text = "↓${weather.daily[0].temp.min.toInt()}°"
        binding.weatherDescription.text = weather.current.weather[0].main
        val resourceId: Int = binding.root.resources.getIdentifier(
            "w_${weather.current.weather[0].icon}",
            "drawable",
            context.packageName
        )
        binding.weatherImage.setImageResource(resourceId)

        return binding.root
    }
}