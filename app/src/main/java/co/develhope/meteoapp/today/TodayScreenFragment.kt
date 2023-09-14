package co.develhope.meteoapp.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.HourlyForecast
import co.develhope.meteoapp.databinding.FragmentTodayScreenBinding
import co.develhope.meteoapp.today.adapter.TodayAdapter
import org.threeten.bp.OffsetDateTime

class TodayScreenFragment : Fragment() {
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

        setupAdapter()


    }

    private fun setupAdapter() {
        val hourlyForecast = Data.getHourlyForecast()

        //   val todayList = Data.getTodayDataList()
        val todayTitle = Data.getTodayTitle()
        val shownItems = createTodayList(hourlyForecast, todayTitle)
        binding.todayRecyclerview.adapter = TodayAdapter(shownItems)

    }

    private fun createTodayList(
        hourlySummaryForecastList: List<HourlyForecast>,
        todayTitle: String
    ): List<HourlyForecastItems> {

        val shownItems = mutableListOf<HourlyForecastItems>()

        shownItems.add(HourlyForecastItems.Title(todayLocation = todayTitle, dateTime = OffsetDateTime.now()))

        //E' un operatore che fa la stessa cosa di forEach o di un while ma in modo più compatto e più facile da leggere
        hourlySummaryForecastList.map { forecast ->
            shownItems.add(
                HourlyForecastItems.Forecast(
                    forecast = forecast
                )
            )

        }

        return shownItems.toList()
    }

    }