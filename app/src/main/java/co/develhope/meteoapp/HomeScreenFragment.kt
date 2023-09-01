package co.develhope.meteoapp

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding


class HomeScreenFragment : Fragment() {
    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupAdapter() {
        val weekList = Data.getWeatherDataList()
        val itemToShow = createItemList(weekList)

    }
    private fun createItemList(dailySummaryForecastList: List<DailySummaryForecast>): List<WeekItems> {
        val itemToShow = mutableListOf<WeekItems>()

        itemToShow.add(WeekItems.Title)
        dailySummaryForecastList.forEach { week ->
            if(week.dayOfWeek == OGGI){
                itemToShow.add(WeekItems.Today(
                    dayOfWeek = week.dayOfWeek,
                    date = week.date,
                    minTemperature = week.minTemperature,
                    maxTemperature = week.maxTemperature,
                    weatherIcon = week.weatherIcon,
                    precipitation = week.precipitation,
                    windSpeed = week.windSpeed
                ))
            }

        }
        itemToShow.add(WeekItems.Subtitle)
        dailySummaryForecastList.forEach { week ->
            if(week.dayOfWeek != OGGI){
                itemToShow.add(WeekItems.Days(
                    dayOfWeek = week.dayOfWeek,
                    date = week.date,
                    minTemperature = week.minTemperature,
                    maxTemperature = week.maxTemperature,
                    weatherIcon = week.weatherIcon,
                    precipitation = week.precipitation,
                    windSpeed = week.windSpeed
                ))
            }

        }
        return itemToShow
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}