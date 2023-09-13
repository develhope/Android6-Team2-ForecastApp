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