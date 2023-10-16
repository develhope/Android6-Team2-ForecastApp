package co.develhope.meteoapp.data.local

import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.data.domain.WeatherIcon
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.today.HourlyForecastItems
import org.threeten.bp.OffsetDateTime

class WeeklyDataLocal(): ArrayList<WeeklyDataLocal.WeeklyLocal>() {
    data class WeeklyLocal(
        val date: OffsetDateTime,
        val minTemperature: Double?,
        val maxTemperature: Double?,
        val weatherIcon: Int?,
        val precipitation: Double?,
        val windSpeed: Double?
    )
}
fun WeeklyDataLocal?.toWeekItems(): List<WeekItems> {
    val newList = mutableListOf<WeekItems>()
    newList.add(WeekItems.HomeTitle(Data.getCityLocation()))

    this?.forEach { week ->
        if (week.date.dayOfMonth == OffsetDateTime.now().dayOfMonth) {
            newList.add(
                WeekItems.Today(
                    DailySummaryForecast(
                        date = week.date,
                        minTemperature = week.minTemperature?.toInt()?:0,
                        maxTemperature = week.maxTemperature?.toInt()?:0,
                        weatherIcon = week.weatherIcon?:0,
                        precipitation = week.precipitation?.toInt()?:0,
                        windSpeed = week.windSpeed?.toInt()?:0
                    )


                )
            )
        }
    }


    newList.add(WeekItems.HomeSubtitle)

    this?.forEach { week ->
        if (week.date.dayOfMonth != OffsetDateTime.now().dayOfMonth) {
            newList.add(
                WeekItems.Days(
                    DailySummaryForecast(
                        date = week.date,
                        minTemperature = week.minTemperature?.toInt()?:0,
                        maxTemperature = week.maxTemperature?.toInt()?:0,
                        weatherIcon = week.weatherIcon?:0,
                        precipitation = week.precipitation?.toInt()?:0,
                        windSpeed = week.windSpeed?.toInt()?:0
                    )
                )
            )
        }

    }
    return newList
}