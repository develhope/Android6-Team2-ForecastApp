package co.develhope.meteoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    enum class weatherIcons(val image: Int) {
        sun(R.drawable.sun),
        rain(R.drawable.rain),
        sun_cloud(R.drawable.sun_cloud)
    }
}

