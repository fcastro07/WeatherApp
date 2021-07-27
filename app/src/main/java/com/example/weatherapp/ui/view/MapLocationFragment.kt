package com.example.weatherapp.ui.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentMapLocationBinding
import com.example.weatherapp.ui.viewmodel.MapLocationViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapLocationFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMapLocationBinding
    private lateinit var map: GoogleMap
    private val mapLocationViewModel: MapLocationViewModel by viewModels()
    private var hasLocationPermission : Boolean = false
    private var currentMarkerWeather : Marker? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root
        requestPermissions()
        createMapFragment()
        observeWeather()
        return root
    }

    private fun requestPermissions() {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            val permissionRequest = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                if (!it) {
                    Toast.makeText(
                        requireActivity(),
                        "Location permission is required to show your location",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    hasLocationPermission = true
                }
            }

            permissionRequest.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            hasLocationPermission = true
        }
    }

    private fun createMapFragment() {
        val mapFragment = childFragmentManager.
            findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun observeWeather() {
        mapLocationViewModel.weather.observe(viewLifecycleOwner, { weather ->
            currentMarkerWeather?.remove()
            val markerInfoWindowAdapter = WeatherInfoWindowAdapter(requireContext(), weather)
            map.setInfoWindowAdapter(markerInfoWindowAdapter)
            val position = mapLocationViewModel.location.value!!
            currentMarkerWeather = map.addMarker(MarkerOptions().position(position))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 18F))
            currentMarkerWeather?.showInfoWindow()
        })
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.isMyLocationEnabled = hasLocationPermission
        map.setOnMapClickListener {
            mapLocationViewModel.updateWeather(it.latitude, it.longitude)
        }
    }
}