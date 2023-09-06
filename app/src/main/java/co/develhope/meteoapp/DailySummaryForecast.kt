package co.develhope.meteoapp

import java.time.LocalDate

data class DailySummaryForecast(
    val date: LocalDate,
    val minTemperature: Int,
    val maxTemperature: Int,
    val weatherIcon: WeatherIcon,
    val precipitation: Int,
    val windSpeed: Int,
) {
    enum class WeatherIcon(val image: Int) {
        SUN(R.drawable.sun),
        RAIN(R.drawable.rain),
        SUN_CLOUD(R.drawable.sun_cloud)
    }
}
