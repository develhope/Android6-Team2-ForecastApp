package co.develhope.meteoapp.data


import android.util.Log
import co.develhope.meteoapp.home.WeekItems
import co.develhope.meteoapp.search.DataSearches
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

object Data {

//    private var searchedData: DataSearches? = null

    private var searchedData: DataSearches? = null
    private var selectedDate: OffsetDateTime? = OffsetDateTime.now().plusDays(1)

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
        return if(searchedData == null){
            DataSearches.itemSearch("Roma","Lazio", latitude = 41.89, longitude = 12.51)
        } else{
            searchedData
        }
    }

    fun getCityLocation(): String {
        return if(searchedData is DataSearches.itemSearch){
            "${(searchedData as DataSearches.itemSearch).recentCitySearch}, ${(searchedData as DataSearches.itemSearch).admin1}"
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

}

