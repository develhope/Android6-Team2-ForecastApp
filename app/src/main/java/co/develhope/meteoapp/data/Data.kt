package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.DataSearches
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

    fun getSearchData(): List<DataSearches.itemSearch> {
        return listOf<DataSearches.itemSearch>(
            DataSearches.itemSearch("Palermo", "14°", "soleggiato"),
            DataSearches.itemSearch("Agrigento", "16°", "parz. nuvoloso"),
            DataSearches.itemSearch("Catania", "20°", "soleggiato"),
            DataSearches.itemSearch("Siracusa", "12°", "pioggia"),
        )
    }



//insrisci i dati giusti

    fun getTodayTitle(): String = "Palermo, Sicilia"

    fun getTitle(): String {
        val homeTitle = WeekItems.HomeTitle(locality = "Palermo, Sicilia")
        return homeTitle.locality
    }


}