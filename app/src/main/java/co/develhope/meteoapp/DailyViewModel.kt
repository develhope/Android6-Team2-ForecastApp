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

    private val _result = MutableLiveData<DailyDataLocal?>()
    val result: LiveData<DailyDataLocal?>
        get() = _result

    fun getDaily() {
        viewModelScope.launch(IO) {
            val response = WeatherRepo.getWeather()
            if (response != null) {
                _result.postValue(response)
                Log.i("NETWORK DATA", "$response")
            } else {
                Log.e("NETWORK ERROR", "Couldn't achieve network call.")
            }
        }
    }

}