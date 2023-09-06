package co.develhope.meteoapp

sealed class TodayData(val type: Int) {

    data class TodayItem(
        val todayTime: String,
        val todayWeatherImage: Int,
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
    ): TodayData(todayItem)

    companion object{
        const val todayItem = 1
    }

}

enum class TodayType{
    ITEM
}