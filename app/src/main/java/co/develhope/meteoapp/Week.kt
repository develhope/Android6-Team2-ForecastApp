package co.develhope.meteoapp

data class Week(val dayOfWeek: String,
val date: String,
val minTemperature: Int,
val maxTemperature: Int,
val weatherIcon: MainActivity.weatherIcons,
val precipitation: Int,
val windSpeed: Int,
val type: DayType
) {
    enum class DayType{
    TODAY, DAYS
    }
}
