package com.example.weatherapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentMyLocationBinding
import com.example.weatherapp.ui.viewmodel.MyLocationViewModel

class MyLocationFragment : Fragment() {

    private lateinit var binding: FragmentMyLocationBinding
    private val myLocationViewModel: MyLocationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        myLocationViewModel.updateWeather()


//        val textView: TextView = binding.textMyLocation
//        myLocationViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}