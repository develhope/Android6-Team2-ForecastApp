package co.develhope.meteoapp.home

import co.develhope.meteoapp.data.domain.WeatherIcon
import org.threeten.bp.OffsetDateTime


sealed class WeekItems(val id : Int){

    data class Today(
        val date: OffsetDateTime,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: WeatherIcon,
        val precipitation: Int,
        val windSpeed: Int,
    ): WeekItems(TodayId)
    data class Days(
        val date: OffsetDateTime,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: WeatherIcon,
        val precipitation: Int,
        val windSpeed: Int,
    ): WeekItems(DaysId)

    data class HomeTitle(
        val locality: String
    ): WeekItems(HomeTitleId)

    object HomeSubtitle : WeekItems(HomeSubtitleId)
    companion object {
        const val TodayId = 1
        const val DaysId = 2
        const val HomeTitleId = 3
        const val HomeSubtitleId = 4
    }
}

