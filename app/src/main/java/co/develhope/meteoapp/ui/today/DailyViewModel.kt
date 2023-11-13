package co.develhope.meteoapp.ui.today

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.data.domain.DailyDataLocal
import co.develhope.meteoapp.network.WeatherRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
//TODO come norma il nome del viewmodel ricalca il nome della schermata che gestisce e a cui è accoppiato
class DailyViewModel @Inject constructor(private val repo: WeatherRepo): ViewModel() {
    //TODO Puoi gestire tutti gl istati della ui con un solo live data e una sealed class così avrai solo eventi che si susseguono e non eventi concorrenti

    private val _result = MutableLiveData<DailyDataLocal?>()

    private val _isLoading = MutableLiveData<Boolean>()

    val result: LiveData<DailyDataLocal?>
        get() = _result

    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        _isLoading.value = false
    }
    //TODO ogni schermata deve avere il proprio viewmodel. Se 2 schermate hanno lo stesso viewmodel significa che sono identiche, quindi una delle due è
    // superflua
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
                Log.e("NETWORK ERROR", "Couldn't achieve network call. (Today Screen)")
            }
        }
    }

}