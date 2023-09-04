package co.develhope.meteoapp

import java.time.LocalDate

//ho rinominato la classe da week a DailySummaryForecast
data class DailySummaryForecast(
    val dayOfWeek: String,
    val date: LocalDate,
    val minTemperature: Int,
    val maxTemperature: Int,
    val weatherIcon: weatherIcons,
    val precipitation: Int,
    val windSpeed: Int,
) {
    enum class weatherIcons(val image: Int) {
        SUN(R.drawable.sun),
        RAIN(R.drawable.rain),
        SUN_CLOUD(R.drawable.sun_cloud)
    }
}
