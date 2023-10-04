package co.develhope.meteoapp.search

import android.R
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.WeatherRepo
import co.develhope.meteoapp.WeatherService
import co.develhope.meteoapp.data.remote.Result
import co.develhope.meteoapp.data.remote.SearchDataRemote
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    private val _cityHints = MutableLiveData<SearchDataRemote?>()
    val cityHints: LiveData<SearchDataRemote?>
        get() = _cityHints

    fun getHintText() {

        viewModelScope.launch(IO) {

            var response = WeatherRepo.getSearchCity()
            if (response != null) {
                _cityHints.postValue(response.body())
            } else {
                Log.e("ERROR", "network error ")
            }
        }
    }
}

