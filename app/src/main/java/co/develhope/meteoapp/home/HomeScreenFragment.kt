package co.develhope.meteoapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        val weekList = Data.getWeatherDataList()
        val itemsToShow = createItemList(weekList)
        binding.homeRecyclerView.adapter = WeekAdapter(list = itemsToShow) {}

    }
    private fun createItemList(dailySummaryForecastList: List<DailySummaryForecast>): List<WeekItems> {
        // manca una un pezzo di logica fondamentale. Sei sicura che la lista sia ordinata nel modo corretto?

        val itemToShow = mutableListOf<WeekItems>()

        itemToShow.add(HomeTitle)
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
        dailySummaryForecastList.forEach { week ->
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