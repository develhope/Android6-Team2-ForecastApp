package co.develhope.meteoapp

sealed class WeekItems(){
    data class Today(
        val dayOfWeek: String,
        val date: String,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: MainActivity.weatherIcons,
        val precipitation: Int,
        val windSpeed: Int,
    ): WeekItems()
    data class Days(
        val dayOfWeek: String,
        val date: String,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: MainActivity.weatherIcons,
        val precipitation: Int,
        val windSpeed: Int,
    ): WeekItems()

    object title : WeekItems()
    object subtitle : WeekItems()
}

