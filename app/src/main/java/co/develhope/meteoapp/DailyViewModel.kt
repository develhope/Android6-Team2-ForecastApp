package co.develhope.meteoapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DailyViewModel: ViewModel() {

    val result = MutableLiveData<DailyData?>()

    fun getDaily(){
        viewModelScope.launch(IO) {
            var response = WeatherRepo.getWeather()
            if (response?.isSuccessful == true){
                result.postValue(response.body())
                Log.i("NETWORK DATA","${response.body()}")
            } else{
                Log.e("NETWORK ERROR","Couldn't achieve network call.")
            }
        }
    }

}