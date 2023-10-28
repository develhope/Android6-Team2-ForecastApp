package co.develhope.meteoapp.data




import android.content.Context
import android.location.Location
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext

import co.develhope.meteoapp.ui.home.adapter.WeekItems
import co.develhope.meteoapp.ui.search.adapter.DataSearches
import org.threeten.bp.OffsetDateTime


object Data {

//    private var searchedData: DataSearches? = null

    private var searchedData: DataSearches? = null
    private var selectedDate: OffsetDateTime? = OffsetDateTime.now().plusDays(1)
    private var selectedCondition: Int? = 0
    private var todayCondition: Int? = 0
    private val recentSearches : MutableList<DataSearches> = mutableListOf()
    private const val PREFERENCES_NAME = "location"
    private const val KEY_LATITUDE = "latitude"
    private const val KEY_LONGITUDE = "longitude"

    fun getTodayTitle(): String = "Palermo, Sicilia"

    fun getTitle(): String {
        val homeTitle = WeekItems.HomeTitle(locality = "Palermo, Sicilia")
        return homeTitle.locality
    }

    // This function is for save da data when users click on search hints.
    fun saveSearchCity(data: DataSearches) {
        Log.d("SAVE DATA", "saved clicked $data")
        searchedData = data
        saveSearchedCityList(data)
    }

    // Use this function for take the saved data.
    fun getSearchCity(): DataSearches? {
        return if(searchedData == null){
            DataSearches.ItemSearch("Roma","Lazio", latitude = 41.89, longitude = 12.51)
        } else{
            searchedData
        }
    }

    fun getCityLocation(): String {
        return if(searchedData is DataSearches.ItemSearch){
            "${(searchedData as DataSearches.ItemSearch).recentCitySearch}, ${(searchedData as DataSearches.ItemSearch).admin1}"
        } else{
            "Roma, Lazio"
        }
    }

    fun saveDate(savedDate: OffsetDateTime){
        selectedDate = savedDate
    }

    fun getSavedDate(): OffsetDateTime?{
        return selectedDate
    }

    fun saveWeatherCondition(savedCondition: Int){
        selectedCondition = savedCondition
    }

    fun getSavedCondition(): Int?{
        return selectedCondition
    }

    fun weatherCodetoCondition(weatherCode: Int): String{
        return when(weatherCode){
            in 0..1 -> "Sereno"
            in 2..48 -> "Nuvoloso"
            in 49..200 -> "Piovoso"
            else -> "Non disponibile"
        }
    }

    fun saveTodayCondition(savedTodayCondition: Int){
        todayCondition = savedTodayCondition
    }

    fun getTodayCondition(): Int?{
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

    fun getRecentSearches() : List<DataSearches>{
        return listOf(DataSearches.SearchTitle("Ricerche recenti")) + recentSearches.toList()
    }


    fun moveSearchToTop(selectedItem: DataSearches) {
        if (recentSearches.contains(selectedItem)) {
            recentSearches.remove(selectedItem)
            recentSearches.add(0, selectedItem)
        }
    }


    fun saveLocation(context: Context, location: Location) {
        val sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putFloat(KEY_LATITUDE, location.latitude.toFloat())
            putFloat(KEY_LONGITUDE, location.longitude.toFloat())
            apply()
        }
    }

    fun getLocation(context: Context): Location? {
        val sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        if (sharedPreferences.contains(KEY_LATITUDE) && sharedPreferences.contains(KEY_LONGITUDE)) {
            val location = Location("")
            location.latitude = sharedPreferences.getFloat(KEY_LATITUDE, 0f).toDouble()
            location.longitude = sharedPreferences.getFloat(KEY_LONGITUDE, 0f).toDouble()
            return location
        }
        return null
    }


}

