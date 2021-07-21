package com.example.weatherapp.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.DailyWeatherModel
import com.example.weatherapp.databinding.ItemWeekWeatherBinding
import java.util.*

class WeekAdapter(private var weathersOfWeek: List<DailyWeatherModel>) : RecyclerView.Adapter<WeekAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemWeekWeatherBinding.bind(view)
        fun bind(weather : DailyWeatherModel) {
            binding.currentDegrees.text = "${weather.temp.day.toInt()}°"
            binding.max.text = "↑${weather.temp.max.toInt()}°"
            binding.min.text = "↓${weather.temp.min.toInt()}°"
            binding.weatherDescription.text = weather.weather[0].main
            val resourceId: Int = itemView.resources.getIdentifier(
                "w_${weather.weather[0].icon}",
                "drawable",
                itemView.context.packageName
            )
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

    override fun getItemCount(): Int {
        return weathersOfWeek.size
    }
}