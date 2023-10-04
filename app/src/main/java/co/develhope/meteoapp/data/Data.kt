package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.search.DataSearches

import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.data.domain.HourlyForecast
import co.develhope.meteoapp.data.domain.WeatherIcon.RAIN
import co.develhope.meteoapp.data.domain.WeatherIcon.SUN
import co.develhope.meteoapp.data.domain.WeatherIcon.SUN_CLOUD
import co.develhope.meteoapp.home.WeekItems
import org.threeten.bp.OffsetDateTime


object Data {

    fun getSearchData(): List<DataSearches.itemSearch> {
        return listOf<DataSearches.itemSearch>(
            DataSearches.itemSearch("Palermo", "14°", "soleggiato"),
            DataSearches.itemSearch("Agrigento", "16°", "parz. nuvoloso"),
            DataSearches.itemSearch("Catania", "20°", "soleggiato"),
            DataSearches.itemSearch("Siracusa", "12°", "pioggia"),
        )
    }



//insrisci i dati giusti
    fun getHourlyForecast(): List<HourlyForecast> = listOf(
        HourlyForecast(
            date = OffsetDateTime.now(),
            hourlyTemp = 30,
            possibleRain = 20,
            apparentTemp = 31,
            uvIndex = 2,
            humidity = 10,
            windDirection = "SSE",
            windSpeed = 3,
            cloudyness = 20,
            rain = 3,
            forecastIndex = 1,
        ),
        HourlyForecast(
            date = OffsetDateTime.now().plusHours(1),
            hourlyTemp = 31,
            possibleRain = 20,
            apparentTemp = 31,
            uvIndex = 2,
            humidity = 10,
            windDirection = "SSE",
            windSpeed = 4,
            cloudyness = 22,
            rain = 3,
            forecastIndex = 2
        )
    )
    fun getTodayTitle(): String = "Palermo, Sicilia"

    fun getTitle(): String {
        val homeTitle = WeekItems.HomeTitle(locality = "Palermo, Sicilia")
        return homeTitle.locality
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeatherDataList(): List<DailySummaryForecast> {

        val today = OffsetDateTime.now()
        val tomorrow = today.plusDays(1)
        val todayPlus2 = today.plusDays(2)
        val todayPlus3 = today.plusDays(3)
        val todayPlus4 = today.plusDays(4)
        val todayPlus5 = today.plusDays(5)


        return listOf(
            DailySummaryForecast(
                date = tomorrow,
                minTemperature = 22,
                maxTemperature = 30,
                weatherIcon = SUN,
                precipitation = 0,
                windSpeed = 10
            ),
            DailySummaryForecast(
                date = today,
                minTemperature = 22,
                maxTemperature = 30,
                weatherIcon = SUN,
                precipitation = 0,
                windSpeed = 10
            ),
            DailySummaryForecast(
                date = todayPlus3,
                minTemperature = 20,
                maxTemperature = 28,
                weatherIcon = SUN_CLOUD,
                precipitation = 0,
                windSpeed = 12
            ),
            DailySummaryForecast(
                date = todayPlus5,
                minTemperature = 21,
                maxTemperature = 30,
                weatherIcon = SUN_CLOUD,
                precipitation = 0,
                windSpeed = 12
            ),
            DailySummaryForecast(
                date = todayPlus2,
                minTemperature = 18,
                maxTemperature = 25,
                weatherIcon = RAIN,
                precipitation = 60,
                windSpeed = 15
            ),
            DailySummaryForecast(
                date = todayPlus4,
                minTemperature = 21,
                maxTemperature = 29,
                weatherIcon = SUN_CLOUD,
                precipitation = 5,
                windSpeed = 15
            )

        )
    }
}