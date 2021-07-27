package com.example.weatherapp.core

import android.content.Context

object IconHelper {
    fun getSVGResourceId(iconName: String, context : Context): Int {
        return context.resources.getIdentifier(
            "w_${iconName}",
            "drawable",
            context.packageName
        )
    }
}