package co.develhope.meteoapp.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.HourlySummaryForecast
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
        val todayList = Data.getTodayDataList()
        val todayTitle = Data.getTodayTitle()
        val shownItems = createTodayList(todayList, todayTitle)
        binding.todayRecyclerview.adapter = TodayAdapter(shownItems)

    }

    private fun createTodayList(
        hourlySummaryForecastList: List<HourlySummaryForecast>,
        todayTitle: String
    ): List<TodayData>{
        val currentHour = OffsetDateTime.now()

        val shownItems = mutableListOf<TodayData>()

        shownItems.add(TodayData.TodayTitle(todayLocation = "Palermo, Sicilia"))

        shownItems.add(
            TodayData.TodayItem(
                currentHour,
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2))

        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(1),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(2),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(3),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(4),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(5),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(6),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(7),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(8),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(9),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(10),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(11),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )
        shownItems.add(
            TodayData.TodayItem(
                currentHour.plusHours(12),
                R.drawable.sun,
                20,
                10,
                22,
                10,
                2,
                40,
                2
            ),
        )

        return shownItems.toList()
    }

    }