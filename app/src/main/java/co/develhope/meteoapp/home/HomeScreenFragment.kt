package co.develhope.meteoapp.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.develhope.meteoapp.DailyViewModel
import co.develhope.meteoapp.home.WeekItems.Days
import co.develhope.meteoapp.home.WeekItems.HomeSubtitle
import co.develhope.meteoapp.home.WeekItems.HomeTitle
import co.develhope.meteoapp.home.WeekItems.Today
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.domain.DailySummaryForecast
import co.develhope.meteoapp.data.local.toWeekItems
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
import co.develhope.meteoapp.home.adapter.WeekAdapter
import co.develhope.meteoapp.today.adapter.TodayAdapter
import org.threeten.bp.OffsetDateTime





class HomeScreenFragment : Fragment() {
    private val weeklyViewModel: WeeklyViewModel by viewModels()
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
        weeklyViewModel.getWeekly()
        setupAdapter()
        setupObserver()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupAdapter() {

        binding.homeRecyclerView.adapter = WeekAdapter(listOf()) {}

    }
    private fun setupObserver() {

        weeklyViewModel.isLoading.observe(viewLifecycleOwner){
            binding.homeProgress.isVisible = it
        }

        weeklyViewModel.result.observe(viewLifecycleOwner) {
            (binding.homeRecyclerView.adapter as WeekAdapter).setNewList(it.toWeekItems())
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}