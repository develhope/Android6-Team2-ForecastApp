package co.develhope.meteoapp.tomorrow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.develhope.meteoapp.DailyViewModel
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.HourlyForecast
import co.develhope.meteoapp.data.local.DailyDataLocal
import co.develhope.meteoapp.databinding.FragmentTomorrowScreenBinding
import co.develhope.meteoapp.search.DataSearches
import co.develhope.meteoapp.today.HourlyForecastItems
import co.develhope.meteoapp.tomorrow.adapter.TomorrowAdapter
import org.threeten.bp.OffsetDateTime

class TomorrowScreenFragment : Fragment() {
    private var _binding: FragmentTomorrowScreenBinding? = null
    private val binding get() = _binding!!

    private val dailyViewModel: DailyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTomorrowScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataSearches = Data.getSearchCity()

        var defaultData = DataSearches.itemSearch(
            longitude = 12.51,
            latitude = 41.89,
            recentCitySearch = "Roma",
            admin1 = "Lazio"
        )

        var longitude = defaultData.longitude
        var latitude = defaultData.latitude
        var cityName = defaultData.recentCitySearch
        var cityRegion = defaultData.admin1

        if(dataSearches is DataSearches.itemSearch){
            longitude = dataSearches.longitude
            latitude = dataSearches.latitude
            cityName = dataSearches.recentCitySearch
            cityRegion = dataSearches.admin1
        }

        dailyViewModel.getDaily(latitude!!, longitude!!)

        setupAdapter()
        setupObserver()

    }

    private fun setupAdapter(){
        binding.tomorrowRecyclerview.adapter = TomorrowAdapter(listOf())
    }

    private fun setupObserver(){
        dailyViewModel.isLoading.observe(viewLifecycleOwner){
            binding.tomorrowProgress.isVisible = it
        }

        dailyViewModel.result.observe(viewLifecycleOwner){
            (binding.tomorrowRecyclerview.adapter as TomorrowAdapter).setNewList(it.toHourlyForecastItems())
        }
    }

    private fun DailyDataLocal?.toHourlyForecastItems(): List<HourlyForecastItems>{
        val newList = mutableListOf<HourlyForecastItems>()

        newList.add(HourlyForecastItems.Title(Data.getCityLocation(), OffsetDateTime.now()))

        this?.forEach { hourly ->
            newList.add(
                HourlyForecastItems.Forecast(
                    HourlyForecast(
                        date = hourly.time,
                        hourlyTemp = hourly.temperature2m?.toInt() ?: 0,
                        possibleRain = hourly.rainChance ?: 0,
                        apparentTemp = hourly.apparentTemperature?.toInt() ?: 0,
                        uvIndex = hourly.uvIndex?.toInt() ?: 0,
                        humidity = hourly.humidity ?: 0,
                        windDirection = hourly.windDirection.toString(),
                        windSpeed = hourly.windSpeed?.toInt() ?: 0,
                        cloudyness = hourly.cloudCover ?: 0,
                        rain = hourly.rain?.toInt() ?: 0,
                        forecastIndex = hourly.weathercode ?: 0
                    )
                )
            )
        }
            return newList
    }
}