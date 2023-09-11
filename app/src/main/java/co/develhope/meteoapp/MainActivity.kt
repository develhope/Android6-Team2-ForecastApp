package co.develhope.meteoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import co.develhope.meteoapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        val bottomNav: BottomNavigationView = binding.bottomNavigationView

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
        }


    }

}

