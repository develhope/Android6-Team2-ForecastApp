package co.develhope.meteoapp

//ho rinominato la classe da week a DailySummaryForecast
data class DailySummaryForecast(
    // hai la data quindi nell'oggetto che trasporta i dati non ti serve questo tipo di stringa
    val dayOfWeek: String,
    // prova ad usare Date invece di stringa
    val date: String,
    val minTemperature: Int,
    val maxTemperature: Int,
    val weatherIcon: MainActivity.weatherIcons,
    val precipitation: Int,
    val windSpeed: Int,
//il type non serve in questo caso perchè hai la data con cui puoi discriminare e fare i conti
    val type: DayType
) {
    enum class DayType{
    TODAY, DAYS
    }
}
