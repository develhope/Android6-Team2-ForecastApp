package co.develhope.meteoapp

data class TodayData(
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
)
