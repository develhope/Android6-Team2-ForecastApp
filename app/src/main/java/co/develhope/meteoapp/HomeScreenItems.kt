package co.develhope.meteoapp

sealed class HomeScreenItems(){
    data class Today(
        val dayOfWeek: String,
        val date: String,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: MainActivity.weatherIcons,
        val precipitation: Int,
        val windSpeed: Int
    ): HomeScreenItems()

    data class Days(
        val dayOfWeek: String,
        val date: String,
        val minTemperature: Int,
        val maxTemperature: Int,
        val weatherIcon: MainActivity.weatherIcons,
        val precipitation: Int,
        val windSpeed: Int
    ): HomeScreenItems()

    object title : HomeScreenItems()
    object subtitle : HomeScreenItems()
}

