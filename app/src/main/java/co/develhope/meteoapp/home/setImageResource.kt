package co.develhope.meteoapp.home

import android.widget.ImageView
import co.develhope.meteoapp.data.domain.WeatherIcon

fun ImageView.setWeatherIcon(weatherIcon: WeatherIcon) {
    this.setImageResource(weatherIcon.image)
}