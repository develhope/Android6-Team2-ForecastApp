package co.develhope.meteoapp

sealed class WeekItems(){
    //today in questo caso è ridondante anche alla luce dei commenti negl ialtri files
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
//il nome delle classi hanno la lettera iniziale maiuscola
    object title : WeekItems()
    //il nome delle classi hanno la lettera iniziale maiuscola

    object subtitle : WeekItems()
}

