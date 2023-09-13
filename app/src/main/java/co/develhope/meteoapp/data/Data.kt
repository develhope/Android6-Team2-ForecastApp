package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.data.domain.DailySummaryForecast.WeatherIcon.RAIN
import co.develhope.meteoapp.data.domain.DailySummaryForecast.WeatherIcon.SUN
import co.develhope.meteoapp.data.domain.DailySummaryForecast.WeatherIcon.SUN_CLOUD
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.today.TodayData
import org.threeten.bp.LocalTime
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.OffsetTime
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter


object Data {

    fun createRandomValues(): MutableList<TodayData> {
        val currentHour = OffsetTime.now().hour

        val todayList = mutableListOf<TodayData>()

        todayList.add(TodayData.TodayTitle("Palermo, Sicilia"))



        var hour = currentHour

        while(hour <= 23){
            val image = R.drawable.sun
            val degrees = (0..35).random()
            val rainChance = (0..100).random()
            val perceived = degrees - ((0..5).random())
            val humidity = (0..100).random()
            val wind = (0..5).random()
            val coverage = (0..100).random()
            val rainHeight = (0..5).random()

            val todayData = createWeatherData(
                hour,
                image,
                degrees,
                rainChance,
                perceived,
                humidity,
                wind,
                coverage,
                rainHeight
            )
            todayList.add(todayData)

            hour++
        }

        return todayList

    }

    fun createWeatherData(
        hour: Int,
        image: Int,
        degrees: Int,
        rainChance: Int,
        perceived: Int,
        humidity: Int,
        wind: Int,
        coverage: Int,
        rainHeight: Int
    ): TodayData.TodayItem {
        val time = OffsetTime.of(LocalTime.of(hour, 0), ZoneOffset.UTC)
        val formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm"))
        return TodayData.TodayItem(
            formattedTime,
            image,
            degrees,
            rainChance,
            perceived,
            humidity,
            wind,
            coverage,
            rainHeight)
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