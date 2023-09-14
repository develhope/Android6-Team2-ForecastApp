package co.develhope.meteoapp.today

import co.develhope.meteoapp.data.domain.WeatherIcon

fun getWeatherIconbasedonId(forecastIndex: Int): WeatherIcon {
       return  when(forecastIndex){
            1-> WeatherIcon.SUN
            2 -> WeatherIcon.RAIN
            3 -> WeatherIcon.SUN_CLOUD
            else -> WeatherIcon.NOTAVAILABLE
        }
    }