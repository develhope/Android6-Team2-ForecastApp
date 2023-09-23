package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.R

import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.data.domain.HourlyForecast
import co.develhope.meteoapp.data.domain.HourlySummaryForecast
import co.develhope.meteoapp.data.domain.WeatherIcon.RAIN
import co.develhope.meteoapp.data.domain.WeatherIcon.SUN
import co.develhope.meteoapp.data.domain.WeatherIcon.SUN_CLOUD
import co.develhope.meteoapp.data.domain.WeatherIcon
import co.develhope.meteoapp.home.WeekItems
import org.threeten.bp.OffsetDateTime


object Data {

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
        val todayPlus6 = today.plusDays(6)


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
                minTemperature = 22,
                maxTemperature = 31,
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
                minTemperature = 22,
                maxTemperature = 31,
                weatherIcon = RAIN,
                precipitation = 60,
                windSpeed = 15
            ),
            DailySummaryForecast(
                date = todayPlus4,
                minTemperature = 22,
                maxTemperature = 31,
                weatherIcon = SUN_CLOUD,
                precipitation = 5,
                windSpeed = 15
            ),
            DailySummaryForecast(
                date = todayPlus6,
                minTemperature = 18,
                maxTemperature = 25,
                weatherIcon = RAIN,
                precipitation = 70,
                windSpeed = 30
            )

        )
    }
}