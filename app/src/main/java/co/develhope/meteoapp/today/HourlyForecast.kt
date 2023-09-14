package co.develhope.meteoapp.today

import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domain.HourlyForecast
import org.threeten.bp.OffsetDateTime

sealed class HourlyForecastItems(val type: Int) {

    data class Forecast(
        val forecast: HourlyForecast
    ) : HourlyForecastItems(hourlyForecast)

    data class Title(
        val todayLocation: String,
        val dateTime: OffsetDateTime
    ) : HourlyForecastItems(title)

    companion object {
        const val hourlyForecast = 1
        const val title = 2
    }

}

enum class TodayWeatherIcon(val image: Int){
    SUN(R.drawable.sun),
    RAIN(R.drawable.rain),
    SUN_CLOUD(R.drawable.sun_cloud),
    MOON(R.drawable.moon)
}