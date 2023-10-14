package co.develhope.meteoapp.today

import android.os.Bundle
import android.util.Log
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
import co.develhope.meteoapp.databinding.FragmentTodayScreenBinding
import co.develhope.meteoapp.search.DataSearches
import co.develhope.meteoapp.today.adapter.TodayAdapter
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class TodayScreenFragment : Fragment() {
    private val dailyViewModel: DailyViewModel by viewModels()

    private var _binding: FragmentTodayScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodayScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataSearches = Data.getSearchCity()

        var longitude = DataSearches.ItemSearch(
            longitude = 0.0,
            latitude = 0.0,
            recentCitySearch = "",
            admin1 = ""
        ).longitude
        if (dataSearches is DataSearches.ItemSearch) {
            longitude = dataSearches.longitude
        }

        var latitude = DataSearches.ItemSearch(
            longitude = 0.0,
            latitude = 0.0,
            recentCitySearch = "",
            admin1 = ""
        ).latitude
        if (dataSearches is DataSearches.ItemSearch) {
            latitude = dataSearches.latitude
        }

        val currentDate = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-d"))
        Log.d("DATE:", currentDate)

        dailyViewModel.getDaily(latitude!!, longitude!!,currentDate,currentDate)

        setupAdapter()
        setupObserver()

    }

    private fun setupAdapter() {
        binding.todayRecyclerview.adapter = TodayAdapter(listOf())
    }

    private fun setupObserver() {

        dailyViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.todayProgress.isVisible = it
        }

        dailyViewModel.result.observe(viewLifecycleOwner) {
            (binding.todayRecyclerview.adapter as TodayAdapter).setNewList(it.toHourlyForecastItems())
        }
    }

    //TODO: DA FINIRE

    private fun DailyDataLocal?.toHourlyForecastItems(): List<HourlyForecastItems> {

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
                        forecastIndex = hourly.weathercode ?: 0,
                        isDay = hourly.isDay ?: 0

                    )
                )
            )
        }
        return newList
    }
}