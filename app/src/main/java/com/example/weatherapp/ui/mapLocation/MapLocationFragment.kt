package com.example.weatherapp.ui.mapLocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.databinding.FragmentMapLocationBinding

class MapLocationFragment : Fragment() {

    private lateinit var mapLocationViewModel: MapLocationViewModel
    private var _binding: FragmentMapLocationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mapLocationViewModel =
            ViewModelProvider(this).get(MapLocationViewModel::class.java)

        _binding = FragmentMapLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMapLocation
        mapLocationViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}