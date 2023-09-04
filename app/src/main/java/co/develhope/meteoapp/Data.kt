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


        val todayData = LocalDate.now().dayOfWeek
        val todayDateText = todayData.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)
        val tomorrowDate = LocalDate.now().plusDays(1).dayOfWeek
        val tomorrowDateText = tomorrowDate.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)
        val threeDaysNow = LocalDate.now().plusDays(2).dayOfWeek
        val threeDaysNowText = threeDaysNow.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)
        val fourDaysNow = LocalDate.now().plusDays(3).dayOfWeek
        val fourDaysNowText = fourDaysNow.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)
        val fiveDaysNow = LocalDate.now().plusDays(4).dayOfWeek
        val fiveDaysNowText = fiveDaysNow.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)
        val sixDaysNow = LocalDate.now().plusDays(5).dayOfWeek
        val sixDaysNowText = sixDaysNow.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)
        val sevenDaysNow = LocalDate.now().plusDays(6).dayOfWeek
        val sevenDaysNowText = sevenDaysNow.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)



        return listOf(

            DailySummaryForecast(todayDateText, dateOfYear, 22, 30,
            DailySummaryForecast.weatherIcons.SUN, 0, 10),

            DailySummaryForecast(tomorrowDateText, dateOfYear, 20, 28,
                DailySummaryForecast.weatherIcons.RAIN, 60, 15),

            DailySummaryForecast(threeDaysNowText, dateOfYear, 23, 31,
            DailySummaryForecast.weatherIcons.SUN_CLOUD, 0, 12),

            DailySummaryForecast(fourDaysNowText, dateOfYear, 23, 31,
            DailySummaryForecast.weatherIcons.SUN_CLOUD, 5, 15),

            DailySummaryForecast(fiveDaysNowText, dateOfYear, 20, 28,
                DailySummaryForecast.weatherIcons.SUN_CLOUD, 0, 12),

            DailySummaryForecast(sixDaysNowText, dateOfYear, 18, 24,
                DailySummaryForecast.weatherIcons.RAIN, 70, 30),

            DailySummaryForecast(sevenDaysNowText, dateOfYear, 23, 31,
                DailySummaryForecast.weatherIcons.SUN_CLOUD, 0, 12)
         )
    }
}