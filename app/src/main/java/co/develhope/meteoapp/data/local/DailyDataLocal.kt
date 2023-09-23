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
        val time: String?,
        val weathercode: Int?,
        val windSpeed: Double?,
        val windDirection: Int?,
        val isDay: Int?
    )
}

// TODO: DA FINIRE

fun DailyDataLocal?.toHourlyForecastItems(): List<HourlyForecastItems> {
    val newList = mutableListOf<HourlyForecastItems>()

    newList.add(HourlyForecastItems.Title("Palermo, Sicilia", OffsetDateTime.now()))

    this?.forEach { hourly ->
        newList.add(
            HourlyForecastItems.Forecast(
                HourlyForecast(
                    date = OffsetDateTime.now(),
                    hourlyTemp = hourly.temperature2m?.toInt()?:0,
                    possibleRain = hourly.rainChance?:0,
                    apparentTemp = hourly.apparentTemperature?.toInt()?:0,
                    uvIndex = hourly.uvIndex?.toInt()?:0,
                    humidity = hourly.humidity?:0,
                    windDirection = hourly.windDirection.toString(),
                    windSpeed = hourly.windSpeed?.toInt()?:0,
                    cloudyness = hourly.cloudCover?:0,
                    rain = hourly.rain?.toInt()?:0,
                    forecastIndex = hourly.weathercode?:0

                )
            )
        )
    }

    return newList
}
