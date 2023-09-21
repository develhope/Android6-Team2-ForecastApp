package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.DataSearches
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.data.domain.DailySummaryForecast.WeatherIcon.RAIN
import co.develhope.meteoapp.data.domain.DailySummaryForecast.WeatherIcon.SUN
import co.develhope.meteoapp.data.domain.DailySummaryForecast.WeatherIcon.SUN_CLOUD
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
        val todayPlus6 = today.plusDays(6)


        return listOf(
            DailySummaryForecast(
                date = tomorrow,
                minTemperature = "22°",
                maxTemperature = "30°",
                weatherIcon = SUN,
                precipitation = "0mm",
                windSpeed = "10kmh"
            ),
            DailySummaryForecast(
                date = today,
                minTemperature = "22°",
                maxTemperature = "30°",
                weatherIcon = SUN,
                precipitation = "0mm",
                windSpeed = "10kmh"
            ),
            DailySummaryForecast(
                date = todayPlus3,
                minTemperature = "22°",
                maxTemperature = "31°",
                weatherIcon = SUN_CLOUD,
                precipitation = "0mm",
                windSpeed = "12kmh"
            ),
            DailySummaryForecast(
                date = todayPlus5,
                minTemperature = "21°",
                maxTemperature = "30°",
                weatherIcon = SUN_CLOUD,
                precipitation = "0mm",
                windSpeed = "12kmh"
            ),
            DailySummaryForecast(
                date = todayPlus2,
                minTemperature = "22°",
                maxTemperature = "31°",
                weatherIcon = RAIN,
                precipitation = "60mm",
                windSpeed = "15kmh"
            ),
            DailySummaryForecast(
                date = todayPlus4,
                minTemperature = "22°",
                maxTemperature = "31°",
                weatherIcon = SUN_CLOUD,
                precipitation = "5mm",
                windSpeed = "15kmh"
            ),
            DailySummaryForecast(
                date = todayPlus6,
                minTemperature = "18°",
                maxTemperature = "25°",
                weatherIcon = RAIN,
                precipitation = "70mm",
                windSpeed = "30kmh"
            )

        )
    }
}