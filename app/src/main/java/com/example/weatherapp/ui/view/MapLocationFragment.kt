package com.example.weatherapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.weatherapp.databinding.FragmentMapLocationBinding
import com.example.weatherapp.ui.viewmodel.MapLocationViewModel

class MapLocationFragment : Fragment() {

    private lateinit var binding: FragmentMapLocationBinding
    private val mapLocationViewModel: MapLocationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMapLocation
        mapLocationViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}