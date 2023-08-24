package co.develhope.meteoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    enum class weatherIcons(val image: Int) {
        sun(R.drawable.img_sun),
        rain(R.drawable.img_rain),
        sun_cloud(R.drawable.img_sun_cloud)
    }
}

