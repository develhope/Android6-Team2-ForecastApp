package co.develhope.meteoapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.network.WeatherRepo
import co.develhope.meteoapp.data.domain.WeeklyDataLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repo: WeatherRepo): ViewModel(){
    val result = MutableLiveData<WeeklyDataLocal?>()
    val isLoading = MutableLiveData<Boolean>()
    val navigateToSearchScreen = MutableLiveData<Boolean>()

    init {
        isLoading.value = false
    }


    fun getWeekly(lat: Double, lon: Double){

        isLoading.postValue(true)

        viewModelScope.launch(IO){

            val response = repo.getHomeWeather(lat, lon)
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