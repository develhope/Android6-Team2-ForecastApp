package co.develhope.meteoapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

object Data {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeatherDataList(): List<DailySummaryForecast> {

        val today = LocalDate.now()
        val tomorrow = today.plusDays(1)
        val todayPlus2 = today.plusDays(2)
        val todayPlus3 = today.plusDays(3)
        val todayPlus4 = today.plusDays(4)
        val todayPlus5 = today.plusDays(5)
        val todayPlus6 = today.plusDays(6)
        val todayPlus7 = today.plusDays(7)

        // Le logiche del testo formattato per la data vanno fatte all'interno del viewholder o in generale nella parte delegata alla ui

        /*val todayDateText = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)
        val tomorrowDateText = LocalDate.now().plusDays(1).dayOfWeek
            .getDisplayName(TextStyle.FULL, Locale.ITALIAN).uppercase(Locale.ITALIAN)
        val threeDaysNowText = LocalDate.now().plusDays(1).dayOfWeek
            .getDisplayName(TextStyle.FULL, Locale.ITALIAN).uppercase(Locale.ITALIAN)
        val fourDaysNowText = LocalDate.now().plusDays(1).dayOfWeek
            .getDisplayName(TextStyle.FULL, Locale.ITALIAN).uppercase(Locale.ITALIAN)
        val fiveDaysNowText = LocalDate.now().plusDays(1).dayOfWeek
            .getDisplayName(TextStyle.FULL, Locale.ITALIAN).uppercase(Locale.ITALIAN)
        val sixDaysNowText = LocalDate.now().plusDays(1).dayOfWeek
            .getDisplayName(TextStyle.FULL, Locale.ITALIAN).uppercase(Locale.ITALIAN)
        val sevenDaysNowText = LocalDate.now().plusDays(1).dayOfWeek
            .getDisplayName(TextStyle.FULL, Locale.ITALIAN).uppercase(Locale.ITALIAN)*/



        return listOf(
            DailySummaryForecast(
                date = today,
                minTemperature = 22,
                maxTemperature = 30,
                weatherIcon = DailySummaryForecast.WeatherIcon.SUN,
                precipitation = 0,
                windSpeed = 10
            ),
            DailySummaryForecast(
                date = tomorrow,
                minTemperature = 22,
                maxTemperature = 30,
                weatherIcon = DailySummaryForecast.WeatherIcon.SUN,
                precipitation = 0,
                windSpeed = 10
            ),
            DailySummaryForecast(
                date = todayPlus2,
                minTemperature = 20,
                maxTemperature = 28,
                weatherIcon = DailySummaryForecast.WeatherIcon.RAIN,
                precipitation = 60,
                windSpeed = 15
            ),
            DailySummaryForecast(
                date = todayPlus3,
                minTemperature = 23,
                maxTemperature = 31,
                weatherIcon = DailySummaryForecast.WeatherIcon.SUN_CLOUD,
                precipitation = 0,
                windSpeed = 12
            ),
            DailySummaryForecast(
                date = todayPlus4,
                minTemperature = 23,
                maxTemperature = 31,
                weatherIcon = DailySummaryForecast.WeatherIcon.SUN_CLOUD,
                precipitation = 5,
                windSpeed = 15
            ),
            DailySummaryForecast(
                date = todayPlus5,
                minTemperature = 20,
                maxTemperature = 28,
                weatherIcon = DailySummaryForecast.WeatherIcon.SUN_CLOUD,
                precipitation = 0,
                windSpeed = 12
            ),
            DailySummaryForecast(
                date = todayPlus6,
                minTemperature = 18,
                maxTemperature = 24,
                weatherIcon = DailySummaryForecast.WeatherIcon.RAIN,
                precipitation = 70,
                windSpeed = 30
            ),
            DailySummaryForecast(
                date = todayPlus7,
                minTemperature = 23,
                maxTemperature = 31,
                weatherIcon = DailySummaryForecast.WeatherIcon.SUN_CLOUD,
                precipitation = 0,
                windSpeed = 12
            )
        )
    }
}