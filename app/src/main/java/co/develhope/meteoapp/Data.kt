package co.develhope.meteoapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

object Data {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeatherDataList(): List<DailySummaryForecast> {
        val currentDate = LocalDate.now()
        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formattedDate = currentDate.format(dateFormatter)

        val dayOfTheWeek = LocalDate.now().dayOfWeek
        val dayOfWeekText = dayOfTheWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())

        return listOf(
            DailySummaryForecast(dayOfWeekText, formattedDate, 22, 30,
            MainActivity.weatherIcons.sun, 0, 10, DailySummaryForecast.DayType.TODAY
            ),

            DailySummaryForecast(dayOfWeekText, formattedDate, 20, 28,
            MainActivity.weatherIcons.rain, 60, 15, DailySummaryForecast.DayType.DAYS
            ),

            DailySummaryForecast(dayOfWeekText, formattedDate, 23, 31,
            MainActivity.weatherIcons.sun_cloud, 0, 12, DailySummaryForecast.DayType.DAYS)
         )
    Log.v("HomeScreenFragment","the list is: ${getWeatherDataList()}")
    }
}