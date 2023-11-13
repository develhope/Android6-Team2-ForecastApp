package co.develhope.meteoapp.ui.search

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.domain.SearchDataLocal
import co.develhope.meteoapp.network.SearchRepo
import co.develhope.meteoapp.network.WeatherRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repo: SearchRepo): ViewModel(){
    //TODO Puoi gestire tutti gl istati della ui con un solo live data e una sealed class così avrai solo eventi che si susseguono e non eventi concorrenti
    //TODO da dove arrivano le ricerche recenti? dovrebbero passare dal viemodel
    private val _cityHints = MutableLiveData<SearchDataLocal?>()

    val cityHints: LiveData<SearchDataLocal?>
        get() = _cityHints

    fun clearSearch() {
        _cityHints.postValue(null)
    }

    fun getPlaces(place: String) {
//        Log.d("GET PLACES", place)
        viewModelScope.launch(IO) {
            val response = repo.getSearch(place)
            if (response != null) {
                _cityHints.postValue(response)
                response.forEach {
                    Log.d(
                        "DATA",
                        "${it.admin1},${it.name}, ${it.latitude}, ${it.longitude} "
                    )
                }
            } else {
                //TODO se va in errore cosa succede alla ui?

                Log.e("ERROR", "network error ")
            }
        }
    }
}

