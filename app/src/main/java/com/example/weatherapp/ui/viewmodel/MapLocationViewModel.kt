package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MapLocationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is map location Fragment"
    }
    val text: LiveData<String> = _text
}