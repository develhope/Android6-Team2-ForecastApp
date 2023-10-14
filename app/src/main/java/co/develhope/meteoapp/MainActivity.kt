package co.develhope.meteoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import co.develhope.meteoapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        val bottomNav: BottomNavigationView = binding.bottomNavigationView


//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.home_screen -> bottomNav.menu.findItem(R.id.home_screen).isChecked = true
//                R.id.today_screen -> bottomNav.menu.findItem(R.id.today_screen).isChecked = true
//                R.id.tomorrow_screen -> bottomNav.menu.findItem(R.id.tomorrow_screen).isChecked = true
//                R.id.search_screen -> bottomNav.menu.findItem(R.id.search_screen).isChecked = true
//            }
//        }

        bottomNav.setupWithNavController(navController)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search_screen -> {
                    if (!navController.popBackStack(R.id.search_screen, false)) {
                        it.onNavDestinationSelected(navController)
                    }

                    true
                }

                R.id.home_screen -> {
                    if (!navController.popBackStack(R.id.home_screen, false)) {
                        it.onNavDestinationSelected(navController)
                    }

                    true
                }

                else -> {
                    it.onNavDestinationSelected(navController)
                }
            }

//        bottomNav.setOnItemSelectedListener {
//            it.onNavDestinationSelected(navController)
//            true
//        }
        }

    }
}

