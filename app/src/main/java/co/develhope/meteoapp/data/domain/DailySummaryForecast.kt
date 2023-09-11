package co.develhope.meteoapp.data.domain
import co.develhope.meteoapp.R.drawable
import org.threeten.bp.OffsetDateTime


data class DailySummaryForecast(
    val date: OffsetDateTime,
    val minTemperature: String,
    val maxTemperature: String,
    val weatherIcon: WeatherIcon,
    val precipitation: String,
    val windSpeed: String
) {

    enum class WeatherIcon(val image: Int) {
        SUN(drawable.sun),
        RAIN(drawable.rain),
        SUN_CLOUD(drawable.sun_cloud)
    }
}

