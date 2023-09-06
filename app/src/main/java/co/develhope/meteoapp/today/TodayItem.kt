package co.develhope.meteoapp.today

import co.develhope.meteoapp.R
import org.threeten.bp.OffsetDateTime

sealed class TodayData(val type: Int) {

    data class TodayItem(
        val todayTime: OffsetDateTime,
        val todayWeatherImage: TodayWeatherIcon,
        val todayDegrees: String,
        val todayRainChanceImage: Int,
        val todayRainChance: String,
        val todayArrowImage: Int,
        val todayPerceivedTitle: String,
        val todayPerceived: String,
        val todayUvIndexTitle: String,
        val todayUvIndex: String,
        val todayHumidityTitle: String,
        val todayHumidity: String,
        val todayWindTitle: String,
        val todayWind: String,
        val todayCoverageTitle: String,
        val todayCoverage: String,
        val todayRainHeightTitle: String,
        val todayRainHeight: String
    ) : TodayData(todayItem)

    data class TodayTitle(
        val todayLocation: String,
        val todayDay: String,
        val todayDate: String
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