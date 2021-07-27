package com.example.weatherapp.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.weatherapp.R
import com.example.weatherapp.core.IconHelper
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.databinding.InfowindowWeatherBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import kotlin.math.roundToInt


class WeatherInfoWindowAdapter(
    private var context: Context,
    private var weather: WeatherModel
) : GoogleMap.InfoWindowAdapter {

    override fun getInfoWindow(marker: Marker): View? = null

    override fun getInfoContents(marker: Marker): View {
        val binding = InfowindowWeatherBinding.inflate(LayoutInflater.from(context), null, false)
        binding.currentDegrees.text =
            context.getString(R.string.degrees, weather.current.temp.roundToInt())
        val todayWeather = weather.daily[0]
        binding.max.text =
            context.getString(R.string.max_degrees, todayWeather.temp.max.roundToInt())
        binding.min.text =
            context.getString(R.string.min_degrees, todayWeather.temp.min.roundToInt())
        binding.weatherDescription.text = weather.current.weather[0].main
        val resourceId = IconHelper.getSVGResourceId(weather.current.weather[0].icon, context)
        binding.weatherImage.setImageResource(resourceId)
        return binding.root
    }
}