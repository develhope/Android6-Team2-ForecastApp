package co.develhope.meteoapp.data.domain

import co.develhope.meteoapp.R.drawable
import org.threeten.bp.OffsetDateTime

data class DailySummaryForecast(
    val date: OffsetDateTime,
    val minTemperature: Int,
    val maxTemperature: Int,
    val weatherIcon: WeatherIcon,
    val precipitation: Int,
    val windSpeed: Int,
) {
    enum class WeatherIcon(val image: Int) {
        SUN(drawable.sun),
        RAIN(drawable.rain),
        SUN_CLOUD(drawable.sun_cloud)
    }
}
