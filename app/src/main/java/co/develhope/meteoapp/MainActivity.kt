package co.develhope.meteoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //questa classe no ndeve trovarsi qui è una classe che appartiene agli oggetti di dominio
    // in generale non è mai una buona prassi mescolare le risorse con gli oggetti dominio
    // nel caso specifico se sai che un elemento è sun nel viewholder hai tutta la possibilità di andarti a prendere la risorsa giusta
    enum class weatherIcons(val image: Int) {
        sun(R.drawable.sun),
        rain(R.drawable.rain),
        sun_cloud(R.drawable.sun_cloud)
    }
}

