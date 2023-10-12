package co.develhope.meteoapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.local.DailyDataLocal
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DailyViewModel : ViewModel() {
    val repo = WeatherRepo()

    private val _result = MutableLiveData<DailyDataLocal?>()

    private val _isLoading = MutableLiveData<Boolean>()

    val result: LiveData<DailyDataLocal?>
        get() = _result

    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        _isLoading.value = false
    }

    fun getDaily(lat: Double,
                 lon: Double) {

        _isLoading.postValue(true)

        viewModelScope.launch(IO) {
            val response = repo.getWeather(lat, lon)
            if (response != null) {
                _isLoading.postValue(false)
                _result.postValue(response)
                Log.i("NETWORK DATA", "$response")
            } else {
                Log.e("NETWORK ERROR", "Couldn't achieve network call.")
            }
        }
    }

}