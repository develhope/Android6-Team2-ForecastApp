package co.develhope.meteoapp.today

import co.develhope.meteoapp.data.domain.WeatherIcon

fun getWeatherIconbasedonId(forecastIndex: Int): WeatherIcon {
       return  when(forecastIndex){
           in 0..1-> WeatherIcon.SUN
            in 2..48 -> WeatherIcon.SUN_CLOUD
            null -> WeatherIcon.NOTAVAILABLE
            else -> WeatherIcon.RAIN
        }
    }