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

        val pattern = "dd/MM"
        val dateFormatter = DateTimeFormatter.ofPattern(pattern)
        val currentDate = LocalDate.now()
        val dateOfMonthOne = LocalDate.parse(currentDate.format(dateFormatter), dateFormatter)
        val dateOfMonthTwo = LocalDate.parse(currentDate.plusDays(1)
            .format(dateFormatter), dateFormatter)
        val dateOfMonthThree = LocalDate.parse(currentDate.plusDays(2)
            .format(dateFormatter), dateFormatter)
        val dateOfMonthFour = LocalDate.parse(currentDate.plusDays(3)
            .format(dateFormatter), dateFormatter)
        val dateOfMonthFive = LocalDate.parse(currentDate.plusDays(4)
            .format(dateFormatter), dateFormatter)
        val dateOfMonthSix = LocalDate.parse(currentDate.plusDays(5)
            .format(dateFormatter), dateFormatter)
        val dateOfMonthSeven = LocalDate.parse(currentDate.plusDays(6)
            .format(dateFormatter), dateFormatter)


        val todayDateText = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
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
            .getDisplayName(TextStyle.FULL, Locale.ITALIAN).uppercase(Locale.ITALIAN)



        return listOf(

            DailySummaryForecast(todayDateText, dateOfMonthOne, 22, 30,
            DailySummaryForecast.weatherIcons.SUN, 0, 10),

            DailySummaryForecast(tomorrowDateText, dateOfMonthTwo, 20, 28,
                DailySummaryForecast.weatherIcons.RAIN, 60, 15),

            DailySummaryForecast(threeDaysNowText, dateOfMonthThree, 23, 31,
            DailySummaryForecast.weatherIcons.SUN_CLOUD, 0, 12),

            DailySummaryForecast(fourDaysNowText, dateOfMonthFour, 23, 31,
            DailySummaryForecast.weatherIcons.SUN_CLOUD, 5, 15),

            DailySummaryForecast(fiveDaysNowText, dateOfMonthFive, 20, 28,
                DailySummaryForecast.weatherIcons.SUN_CLOUD, 0, 12),

            DailySummaryForecast(sixDaysNowText, dateOfMonthSix, 18, 24,
                DailySummaryForecast.weatherIcons.RAIN, 70, 30),

            DailySummaryForecast(sevenDaysNowText, dateOfMonthSeven, 23, 31,
                DailySummaryForecast.weatherIcons.SUN_CLOUD, 0, 12)
         )
    }
}