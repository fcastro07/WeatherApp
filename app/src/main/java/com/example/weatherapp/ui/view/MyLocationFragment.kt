package com.example.weatherapp.ui.view

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.core.IconHelper
import com.example.weatherapp.databinding.FragmentMyLocationBinding
import com.example.weatherapp.ui.view.adapter.WeekAdapter
import com.example.weatherapp.ui.viewmodel.MyLocationViewModel
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class MyLocationFragment : Fragment() {

    private lateinit var binding: FragmentMyLocationBinding
    private val myLocationViewModel: MyLocationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        requestLocationPermissions()
        observeWeather()
        observeIsLoading()
        binding.contentPanel.setOnRefreshListener {
            updateLocation(true)
        }

        return root
    }

    private fun requestLocationPermissions() {
        val permissionRequest =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                val allPermissionGranted = permissions.values.all { p -> p == true }
                if (allPermissionGranted) {
                    updateLocation()
                } else {
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.location_required_my_location),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        permissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    @SuppressLint("MissingPermission")
    private fun updateLocation(forceUpdate: Boolean = false) {
        val locationRequest = LocationRequest.create()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        fusedLocationClient.requestLocationUpdates(locationRequest, object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                val location: Location? = locationResult.lastLocation
                if (location != null) {
                    myLocationViewModel.updateWeather(
                        location.latitude,
                        location.longitude,
                        forceUpdate
                    )
                    fusedLocationClient.removeLocationUpdates(this)
                }
            }
        }, null)
    }

    private fun observeWeather() {
        myLocationViewModel.weather.observe(viewLifecycleOwner, { weather ->
            val current = weather.current
            binding.todayWeather.also {
                it.currentDegrees.text = getString(R.string.degrees, current.temp.roundToInt())
                it.feelsLike.text = getString(R.string.feels_like, current.feels_like.roundToInt())
                it.weatherDescription.text = current.weather[0].main
                val resourceId =
                    IconHelper.getSVGResourceId(current.weather[0].icon, requireContext())
                it.weatherImage.setImageResource(resourceId)
            }

            binding.weekRecyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = WeekAdapter(weather.daily)
                it.setHasFixedSize(true)
            }
        })
    }

    private fun observeIsLoading() {
        myLocationViewModel.isLoading.observe(viewLifecycleOwner, {
            if (!binding.contentPanel.isVisible) {
                binding.contentPanel.isVisible = !it
            }

            binding.contentPanel.isRefreshing = it
        })
    }
}