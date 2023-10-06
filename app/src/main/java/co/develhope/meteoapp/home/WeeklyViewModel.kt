package co.develhope.meteoapp.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.WeatherRepo
import co.develhope.meteoapp.data.local.WeeklyDataLocal
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class WeeklyViewModel : ViewModel() {
    val repo = WeatherRepo()
    val result = MutableLiveData<WeeklyDataLocal?>()
    val isLoading = MutableLiveData<Boolean>()
    val navigateToSearchScreen = MutableLiveData<Boolean>()

    init {
        isLoading.value = false
    }


    fun getWeekly(){

        isLoading.postValue(true)

        viewModelScope.launch(IO){

            val response = repo.getHomeWeather(41.8919,12.5113)
            if (response != null) {
                isLoading.postValue(false)
                result.postValue(response)
                Log.i("NETWORK DATA", "$response")
            } else {
                navigateToSearchScreen.postValue(true)


            }
        }
    }

}