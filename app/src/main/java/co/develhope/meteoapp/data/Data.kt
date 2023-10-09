package co.develhope.meteoapp.data


import android.util.Log
import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.home.WeekItems



object Data {

    private var searchedData: SearchDataLocal.ResultLocal? = null




    fun getTodayTitle(): String = "Palermo, Sicilia"

    fun getTitle(): String {
        val homeTitle = WeekItems.HomeTitle(locality = "Palermo, Sicilia")
        return homeTitle.locality
    }




    fun saveSearchCity(data: SearchDataLocal.ResultLocal) {
        Log.d("SAVE DATA", "saved clicked $data")
        searchedData = data
    }

    fun getSearchCity(): SearchDataLocal.ResultLocal? {
        return searchedData
    }


}

