package com.example.weatherapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.weatherapp.ui.view.MapLocationFragment
import com.example.weatherapp.ui.view.MyLocationFragment
import javax.inject.Inject

class MainFragmentFactory @Inject constructor() : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            MyLocationFragment::class.java.name -> MyLocationFragment()
            MapLocationFragment::class.java.name -> MapLocationFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}