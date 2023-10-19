package co.develhope.meteoapp.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.domain.SearchDataLocal
import co.develhope.meteoapp.network.SearchRepo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    val repo = SearchRepo()

    private val _cityHints = MutableLiveData<SearchDataLocal?>()
    val cityHints: LiveData<SearchDataLocal?>
        get() = _cityHints




    fun getPlaces(place: String) {
//        Log.d("GET PLACES", place)
        viewModelScope.launch(IO) {

            var response = repo.getSearch(place)
            if (response != null) {
                _cityHints.postValue(response)
                response.forEach {
                    Log.d(
                        "DATA",
                        "${it.admin1},${it.name}, ${it.latitude}, ${it.longitude} "
                    )
                }
            } else {
                Log.e("ERROR", "network error ")
            }
        }
    }
}

