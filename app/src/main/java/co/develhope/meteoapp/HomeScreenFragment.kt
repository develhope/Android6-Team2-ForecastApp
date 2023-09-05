package co.develhope.meteoapp

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale


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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupAdapter() {
        val weekList = Data.getWeatherDataList()
        val itemsToShow = createItemList(weekList)
        binding.homeRecyclerView.adapter = WeekAdapter(list = itemsToShow) {}

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createItemList(dailySummaryForecastList: List<DailySummaryForecast>): List<WeekItems> {
        val itemToShow = mutableListOf<WeekItems>()
        val today = LocalDate.now().dayOfWeek
        val todayText = today.getDisplayName(TextStyle.FULL, Locale.ITALIAN)
            .uppercase(Locale.ITALIAN)

        itemToShow.add(WeekItems.HomeTitle)
        dailySummaryForecastList.forEach { week ->

            if(week.dayOfWeek == todayText){
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
        itemToShow.add(WeekItems.HomeSubtitle)
        dailySummaryForecastList.forEach { week ->
            if(week.dayOfWeek != todayText){
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