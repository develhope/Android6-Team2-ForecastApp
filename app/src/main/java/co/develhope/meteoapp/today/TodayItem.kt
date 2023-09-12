package co.develhope.meteoapp.today

import co.develhope.meteoapp.R
import org.threeten.bp.LocalTime
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.OffsetTime
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter
import kotlin.random.Random

sealed class TodayData(val type: Int) {

    data class TodayItem(
        val todayTime: String,
        val todayWeatherImage: Int,
        val todayDegrees: Int,
        val todayRainChance: Int,
        val todayPerceived: Int,
        val todayHumidity: Int,
        val todayWind: Int,
        val todayCoverage: Int,
        val todayRainHeight: Int
    ) : TodayData(todayItem)

    data class TodayTitle(
        val todayLocation: String,
    ) : TodayData(todayTitle)

    companion object {
        const val todayItem = 1
        const val todayTitle = 2
    }

}

enum class TodayWeatherIcon(val image: Int){
    SUN(R.drawable.sun),
    RAIN(R.drawable.rain),
    SUN_CLOUD(R.drawable.sun_cloud),
    MOON(R.drawable.moon)
}

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