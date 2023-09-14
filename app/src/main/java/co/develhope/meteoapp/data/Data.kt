package co.develhope.meteoapp.data

import android.os.Build
import androidx.annotation.RequiresApi

import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.data.domain.WeatherIcon.RAIN
import co.develhope.meteoapp.data.domain.WeatherIcon.SUN
import co.develhope.meteoapp.data.domain.WeatherIcon.SUN_CLOUD
import co.develhope.meteoapp.data.domain.WeatherIcon
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.today.HourlyForecastItems
import org.threeten.bp.OffsetDateTime


object Data {

//    fun createRandomValues(): MutableList<TodayData> {
//        val currentHour = OffsetTime.now().hour
//
//        val todayList = mutableListOf<TodayData>()
//
//        todayList.add(TodayData.TodayTitle("Palermo, Sicilia"))
//
//
//
//        var hour = currentHour
//
//        while(hour <= 23){
//            val image = R.drawable.sun
//            val degrees = (0..35).random()
//            val rainChance = (0..100).random()
//            val perceived = degrees - ((0..5).random())
//            val humidity = (0..100).random()
//            val wind = (0..5).random()
//            val coverage = (0..100).random()
//            val rainHeight = (0..5).random()
//
//            val todayData = createWeatherData(
//                hour,
//                image,
//                degrees,
//                rainChance,
//                perceived,
//                humidity,
//                wind,
//                coverage,
//                rainHeight
//            )
//            todayList.add(todayData)
//
//            hour++
//        }
//
//        return todayList
//
//    }
//
//    fun createWeatherData(
//        hour: Int,
//        image: Int,
//        degrees: Int,
//        rainChance: Int,
//        perceived: Int,
//        humidity: Int,
//        wind: Int,
//        coverage: Int,
//        rainHeight: Int
//    ): TodayData.TodayItem {
//        val time = OffsetTime.of(LocalTime.of(hour, 0), ZoneOffset.UTC)
//        val formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm"))
//        return TodayData.TodayItem(
//            formattedTime,
//            image,
//            degrees,
//            rainChance,
//            perceived,
//            humidity,
//            wind,
//            coverage,
//            rainHeight)
//    }

    data class HourlyForecast(
        val date: OffsetDateTime,
        val hourlyTemp: Int,
        val possibleRain: Int,
        val apparentTemp: Int, //temp percepita
        val uvIndex: Int,
        val humidity: Int,
        val windDirection: String,
        val windSpeed: Int,
        val cloudyness: Int,
        val rain: Int,
        val forecastIndex: Int
    )

    fun getHourlyForecast(): List<HourlyForecast> = listOf(
        HourlyForecast(
            date = OffsetDateTime.now(),
            hourlyTemp = 2682,
            possibleRain = 1167,
            apparentTemp = 1670,
            uvIndex = 2399,
            humidity = 8136,
            windDirection = "expetenda",
            windSpeed = 8736,
            cloudyness = 7981,
            rain = 3059,
            forecastIndex = 1845,
        ),
        HourlyForecast(
            date = OffsetDateTime.now().plusHours(1),
            hourlyTemp = 7787,
            possibleRain = 2319,
            apparentTemp = 7046,
            uvIndex = 9413,
            humidity = 2990,
            windDirection = "causae",
            windSpeed = 1264,
            cloudyness = 2157,
            rain = 8658,
            forecastIndex = 7452
        )


    )


    fun getTodayDataList(): List<HourlySummaryForecast> {
        val currentHour = OffsetDateTime.now()

        return listOf(
            HourlySummaryForecast(
                time = currentHour,
                weatherImage = R.drawable.sun,
                degrees = 20,
                rainChance = 10,
                perceived = 22,
                humidity = 30,
                wind = 2,
                coverage = 10,
                rainHeight = 2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(1),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(2),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(3),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(4),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(5),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(6),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(7),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(8),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(9),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(10),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(11),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),
            HourlySummaryForecast(
                currentHour.plusHours(12),
                R.drawable.sun,
                20,
                10,
                22,
                30,
                2,
                10,
                2
            ),

        )
    }

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