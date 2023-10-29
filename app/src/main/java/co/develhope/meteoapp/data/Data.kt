package co.develhope.meteoapp.data


import android.content.Context
import android.util.Log
import co.develhope.meteoapp.ui.search.adapter.DataSearches
import org.threeten.bp.OffsetDateTime


object Data {

//    private var searchedData: DataSearches? = null

    private var selectedDate: OffsetDateTime? = OffsetDateTime.now().plusDays(1)
    private var selectedCondition: Int? = 0
    private var todayCondition: Int? = 0
    private val recentSearches: MutableList<DataSearches> = mutableListOf()
    private const val PREFERENCES_NAME = "location"
    private const val KEY_LATITUDE = "latitude"
    private const val KEY_LONGITUDE = "longitude"
    private const val KEY_NAME = "KEY_NAME"
    private const val KEY_REGION = "KEY_REGION"

    // This function is for save da data when users click on search hints.
    fun saveSearchCity(context: Context, data: DataSearches.ItemSearch) {
        Log.d("SAVE DATA", "saved clicked $data")
        val sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString(KEY_NAME, data.recentCitySearch)
            putString(KEY_REGION, data.admin1)
            putFloat(KEY_LATITUDE, data.latitude?.toFloat() ?: 0f)
            putFloat(KEY_LONGITUDE, data.longitude?.toFloat() ?: 0f)
            apply()
        }

        saveSearchedCityList(data)
    }

    // Use this function for take the saved data.
    fun getSearchCity(context: Context): DataSearches? {
        val sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

        return if (sharedPreferences.contains(KEY_LATITUDE) && sharedPreferences.contains(
                KEY_LONGITUDE
            )
        ) {
            DataSearches.ItemSearch(
                recentCitySearch = sharedPreferences.getString(KEY_NAME, "---") ?: "---",
                admin1 = sharedPreferences.getString(KEY_REGION, "---") ?: "---",
                latitude = sharedPreferences.getFloat(KEY_LATITUDE, 0f).toDouble(),
                longitude = sharedPreferences.getFloat(KEY_LONGITUDE, 0f).toDouble()
            )
        } else {
            null
        }
    }

    fun getCityLocation(context: Context): String {
        val searchedData = getSearchCity(context)
        return if (searchedData is DataSearches.ItemSearch) {
            "${searchedData.recentCitySearch}, ${searchedData.admin1}"
        } else {
            "---, ---"
        }
    }

    fun saveDate(savedDate: OffsetDateTime) {
        selectedDate = savedDate
    }

    fun getSavedDate(): OffsetDateTime? {
        return selectedDate
    }

    fun saveWeatherCondition(savedCondition: Int) {
        selectedCondition = savedCondition
    }

    fun getSavedCondition(): Int? {
        return selectedCondition
    }

    fun weatherCodetoCondition(weatherCode: Int): String {
        return when (weatherCode) {
            in 0..1 -> "Sereno"
            in 2..48 -> "Nuvoloso"
            in 49..200 -> "Piovoso"
            else -> "Non disponibile"
        }
    }

    fun saveTodayCondition(savedTodayCondition: Int) {
        todayCondition = savedTodayCondition
    }

    fun getTodayCondition(): Int? {
        return todayCondition
    }


    fun saveSearchedCityList(data: DataSearches) {
        if (!recentSearches.contains(data)) {
            recentSearches.add(data)
            if (recentSearches.size > 5) {
                recentSearches.removeAt(0)
            }
        }
    }

    fun getRecentSearches(): List<DataSearches> {
        return listOf(DataSearches.SearchTitle("Ricerche recenti")) + recentSearches.toList()
    }


    fun moveSearchToTop(selectedItem: DataSearches) {
        if (recentSearches.contains(selectedItem)) {
            recentSearches.remove(selectedItem)
            recentSearches.add(0, selectedItem)
        }
    }
}

