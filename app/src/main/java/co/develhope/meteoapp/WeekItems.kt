package co.develhope.meteoapp

import java.time.LocalDate

sealed class WeekItems(val id : Int){
    //today in questo caso è ridondante anche alla luce dei commenti negl ialtri files
    data class Today(
        val dayOfWeek: String,
        val date: LocalDate,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: DailySummaryForecast.weatherIcons,
        val precipitation: Int,
        val windSpeed: Int,
    ): WeekItems(TodayId)
    data class Days(
        val dayOfWeek: String,
        val date: LocalDate,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: DailySummaryForecast.weatherIcons,
        val precipitation: Int,
        val windSpeed: Int,
    ): WeekItems(DaysId)

    object HomeTitle: WeekItems(HomeTitleId)

    object HomeSubtitle : WeekItems(HomeSubtitleId)
    companion object {
        const val TodayId = 1
        const val DaysId = 2
        const val HomeTitleId = 3
        const val HomeSubtitleId = 4
    }
}

