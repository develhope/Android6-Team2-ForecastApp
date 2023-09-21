package co.develhope.meteoapp

sealed class DataSearches(val type: Int) {


    data class itemSearch(
        val recentCitySearch: String,
        val recentTemperatureSearch: String,
        val recentWeatherSearch: String
    ) : DataSearches(itemSearch1)

    companion object {
        const val itemSearch1 = 1
    }

}


