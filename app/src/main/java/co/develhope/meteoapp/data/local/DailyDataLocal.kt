package co.develhope.meteoapp.data.local

import co.develhope.meteoapp.data.domain.HourlyForecast
import co.develhope.meteoapp.today.HourlyForecastItems
import org.threeten.bp.OffsetDateTime


class DailyDataLocal() : ArrayList<DailyDataLocal.HourlyLocal>() {
    data class HourlyLocal(
        val apparentTemperature: Double?,
        val cloudCover: Int?,
        val rainChance: Int?,
        val humidity: Int?,
        val uvIndex: Double?,
        val rain: Double?,
        val temperature2m: Double?,
        val time: OffsetDateTime,
        val weathercode: Int?,
        val windSpeed: Double?,
        val windDirection: String?,
        val isDay: Int?
    )
}
