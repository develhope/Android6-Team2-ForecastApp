package co.develhope.meteoapp.today

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
import co.develhope.meteoapp.data.local.toHourlyForecastItems
import co.develhope.meteoapp.databinding.FragmentTodayScreenBinding
import co.develhope.meteoapp.today.adapter.TodayAdapter
import org.threeten.bp.OffsetDateTime

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

        dailyViewModel.getDaily()

        setupAdapter()
        setupObserver()

    }

    private fun setupAdapter() {

        binding.todayRecyclerview.adapter = TodayAdapter(listOf())

    }

    private fun setupObserver() {

        dailyViewModel.isLoading.observe(viewLifecycleOwner){
            binding.todayProgress.isVisible = it
        }

        dailyViewModel.result.observe(viewLifecycleOwner) {
            (binding.todayRecyclerview.adapter as TodayAdapter).setNewList(it.toHourlyForecastItems())
        }
    }
}