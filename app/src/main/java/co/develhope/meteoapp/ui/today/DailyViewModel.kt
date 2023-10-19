package co.develhope.meteoapp.ui.today

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.network.WeatherRepo
import co.develhope.meteoapp.data.domain.DailyDataLocal
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
                 lon: Double,
                 startDate: String,
                 endDate: String) {

        _isLoading.postValue(true)

        viewModelScope.launch(IO) {
            val response = repo.getWeather(lat, lon, startDate, endDate)
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