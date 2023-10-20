package co.develhope.meteoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import co.develhope.meteoapp.R.id
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.threeten.bp.OffsetDateTime

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

    }
}

