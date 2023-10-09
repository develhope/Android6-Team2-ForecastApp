package co.develhope.meteoapp.data


import android.util.Log
import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.search.DataSearches


object Data {

    private var searchedData: DataSearches? = null




    fun getTodayTitle(): String = "Palermo, Sicilia"

    fun getTitle(): String {
        val homeTitle = WeekItems.HomeTitle(locality = "Palermo, Sicilia")
        return homeTitle.locality
    }



    // This function is for save da data when users click on search hints.
    fun saveSearchCity(data: DataSearches?) {
        Log.d("SAVE DATA", "saved clicked $data")
        searchedData = data
    }


    // Use this function for take the saved data.
    fun getSearchCity(): DataSearches? {
        return searchedData
    }


}

