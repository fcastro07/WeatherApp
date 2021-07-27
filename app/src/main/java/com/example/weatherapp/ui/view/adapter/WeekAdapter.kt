package com.example.weatherapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.core.IconHelper
import com.example.weatherapp.data.model.DailyWeatherModel
import com.example.weatherapp.databinding.ItemWeekWeatherBinding
import java.util.*
import kotlin.math.roundToInt

class WeekAdapter(private var weathersOfWeek: List<DailyWeatherModel>) :
    RecyclerView.Adapter<WeekAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemWeekWeatherBinding.bind(view)
        fun bind(weather: DailyWeatherModel) {
            val context = itemView.context
            val temp = weather.temp
            binding.currentDegrees.text = context.getString(R.string.degrees, temp.day.roundToInt())
            binding.max.text = context.getString(R.string.max_degrees, temp.max.roundToInt())
            binding.min.text = context.getString(R.string.min_degrees, temp.min.roundToInt())
            binding.weatherDescription.text = weather.weather[0].main
            val resourceId = IconHelper.getSVGResourceId(weather.weather[0].icon, itemView.context)
            binding.weatherImage.setImageResource(resourceId)
            val weekday = java.lang.String.format(Locale.ENGLISH, "%tA", weather.dt * 1000L)
            binding.day.text = weekday
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_week_weather, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = weathersOfWeek[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = weathersOfWeek.size
}