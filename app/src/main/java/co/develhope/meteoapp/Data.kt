package co.develhope.meteoapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

object Data {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeatherDataList(): List<DailySummaryForecast> {
        val currentDate = LocalDate.now()
        val pattern = "dd/MM/yyyy"
        val dateFormatter = DateTimeFormatter.ofPattern(pattern)
        val formattedDate = currentDate.format(dateFormatter)
        val dateOfYear = LocalDate.parse(formattedDate, dateFormatter)


        val dayOfTheWeek = LocalDate.now().dayOfWeek
        val dayOfWeekText = dayOfTheWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
            .uppercase(Locale.getDefault())
        val dateFormatterWeek = DateTimeFormatter.ofPattern("EEEE", Locale.getDefault())
        val dayOfWeek = LocalDate.parse(dayOfWeekText, dateFormatterWeek)

        return listOf(
            DailySummaryForecast(dayOfWeek, dateOfYear, 22, 30,
            DailySummaryForecast.weatherIcons.SUN, 0, 10),

            DailySummaryForecast(dayOfWeek, dateOfYear, 20, 28,
                DailySummaryForecast.weatherIcons.RAIN, 60, 15),

            DailySummaryForecast(dayOfWeek, dateOfYear, 23, 31,
            DailySummaryForecast.weatherIcons.SUN_CLOUD, 0, 12)
         )
    }
}