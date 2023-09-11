package co.develhope.meteoapp.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.home.WeekItems.Days
import co.develhope.meteoapp.home.WeekItems.HomeSubtitle
import co.develhope.meteoapp.home.WeekItems.HomeTitle
import co.develhope.meteoapp.home.WeekItems.Today
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
import co.develhope.meteoapp.home.adapter.WeekAdapter
import org.threeten.bp.OffsetDateTime





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
        val titleHome = Data.getTitle()
        val itemsToShow = createItemList(weekList, titleHome)
        binding.homeRecyclerView.adapter = WeekAdapter(list = itemsToShow) {}

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createItemList(
        dailySummaryForecastList: List<DailySummaryForecast>,
        titleHome: String
    ): List<WeekItems> {

        val itemToShow = mutableListOf<WeekItems>()

        itemToShow.add(HomeTitle(titleHome))

        dailySummaryForecastList.forEach { week ->
            if (week.date.dayOfMonth == OffsetDateTime.now().dayOfMonth) {
                itemToShow.add(
                    Today(
                        date = week.date,
                        minTemperature = week.minTemperature,
                        maxTemperature = week.maxTemperature,
                        weatherIcon = week.weatherIcon,
                        precipitation = week.precipitation,
                        windSpeed = week.windSpeed
                    )
                )
            }
        }


        itemToShow.add(HomeSubtitle)
        val currentDate = OffsetDateTime.now().dayOfMonth
        val sortedList = dailySummaryForecastList
            .filter { it.date.dayOfMonth != currentDate }
            .sortedBy { it.date }
        sortedList.forEach { week ->
            if (week.date.dayOfMonth != OffsetDateTime.now().dayOfMonth) {
                itemToShow.add(
                    Days(
                        date = week.date,
                        minTemperature = week.minTemperature,
                        maxTemperature = week.maxTemperature,
                        weatherIcon = week.weatherIcon,
                        precipitation = week.precipitation,
                        windSpeed = week.windSpeed
                    )
                )
            }

        }
        return itemToShow.toList()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}