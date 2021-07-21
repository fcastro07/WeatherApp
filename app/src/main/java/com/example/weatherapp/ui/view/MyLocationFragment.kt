package com.example.weatherapp.ui.view

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.FragmentMyLocationBinding
import com.example.weatherapp.ui.viewmodel.MyLocationViewModel
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

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

        updateLocation()

        myLocationViewModel.weatherModel.observe(viewLifecycleOwner, { weather ->
            binding.currentDegrees.text = "${weather.current.temp.toInt()}°"
            binding.feelsLike.text = "Feels Like: ${weather.current.feels_like.toInt()}°"
            binding.weatherDescription.text = weather.current.weather[0].main
            val resourceId: Int = resources.getIdentifier(
                "w_${weather.current.weather[0].icon}",
                "drawable",
                context?.packageName
            )
            binding.weatherImage.setImageResource(resourceId)
            binding.weekRecyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = WeekAdapter(weather.daily)
                it.setHasFixedSize(true)
            }
        })

        myLocationViewModel.isLoading.observe(viewLifecycleOwner, {
            binding.loadingProgress.isVisible = it
            binding.contentPanel.isVisible = !it
        })

        return root
    }

    private fun updateLocation() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        val locationRequest = LocationRequest.create()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val permissionRequest = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                    permissions ->
                permissions.forEach {
                    if (!it.value) {
                        Toast.makeText(
                            requireActivity(),
                            "Location permission is required to show weather in your location",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
            permissionRequest.launch(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION))
            return
        }

        fusedLocationClient.requestLocationUpdates(locationRequest, object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                val location: Location? = locationResult.lastLocation
                if (location != null) {
                    myLocationViewModel.updateWeather(location.latitude, location.longitude)
                    fusedLocationClient.removeLocationUpdates(this)
                }
            }
        }, null)
    }
}