package co.develhope.meteoapp.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import co.develhope.meteoapp.R.id
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.Data.saveSearchCity
import co.develhope.meteoapp.databinding.ActivityMainBinding
import co.develhope.meteoapp.ui.search.adapter.DataSearches
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import org.threeten.bp.OffsetDateTime
import java.util.Locale


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val LOCATION_PERMISSION_REQUEST_CODE = 1
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController = findNavController(id.nav_host_fragment_content_main)
        val bottomNav: BottomNavigationView = binding.bottomNavigationView

//        val viewPager: ViewPager2 = binding.pageChanger
//        val pagerAdapter = ViewPageAdapter(this)
//        viewPager.adapter = pagerAdapter
//
//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                bottomNav.menu.getItem(position).isChecked = true
//            }
//        })

        bottomNav.setupWithNavController(navController)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                id.search_screen -> {
                    if (!navController.popBackStack(id.search_screen, false)) {
                        it.onNavDestinationSelected(navController)
//                        viewPager.currentItem = 3
                    }

                    true
                }

                id.home_screen -> {
                    if (!navController.popBackStack(id.home_screen, false)) {
                        it.onNavDestinationSelected(navController)
//                        viewPager.currentItem = 0
                    }

                    true
                }

                id.today_screen -> {
                    if (!navController.popBackStack(id.today_screen, false)) {
                        it.onNavDestinationSelected(navController)
//                        viewPager.currentItem = 1
                    }

                    true
                }

                id.tomorrow_screen -> {
                    // Reset selected date to tomorrow
                    val tomorrow = OffsetDateTime.now().plusDays(1)
                    Data.saveDate(tomorrow)

                    if (!navController.popBackStack(id.tomorrow_screen, false)) {
                        it.onNavDestinationSelected(navController)
//                        viewPager.currentItem = 2
                    }
                    true
                }

                else -> {
                    it.onNavDestinationSelected(navController)
                    false
                }
            }
        }


        if (Data.getSearchCity(this) == null) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
                fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    if (location != null) {
                        val geocoder = Geocoder(this, Locale.getDefault())
                        val loc = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                        saveSearchCity(
                            this, DataSearches.ItemSearch(
                                recentCitySearch = loc.firstOrNull()?.locality ?: "---",
                                admin1 = loc.firstOrNull()?.adminArea ?: "---",
                                latitude = location.latitude,
                                longitude = location.longitude
                            )
                        )
                    }
                }
            } else {
                // Richiedi il permesso di posizione.
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                    LOCATION_PERMISSION_REQUEST_CODE
                )
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

                    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                        if (location != null) {
                            val geocoder = Geocoder(this, Locale.getDefault())
                            val loc = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                            saveSearchCity(
                                this, DataSearches.ItemSearch(
                                    recentCitySearch = loc.firstOrNull()?.locality ?: "---",
                                    admin1 = loc.firstOrNull()?.adminArea ?: "---",
                                    latitude = location.latitude,
                                    longitude = location.longitude
                                )
                            )
                        }
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Per favore, concedi il permesso di posizione per permettere all'app di funzionare correttamente.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            else -> {
                // Ignora tutti gli altri casi.
            }
        }
    }
}

