package co.develhope.meteoapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.local.toWeekItems
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
import co.develhope.meteoapp.home.adapter.WeekAdapter
import co.develhope.meteoapp.search.DataSearches


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataSearches = Data.getSearchCity()

        var longitude = DataSearches.itemSearch(
            longitude = 0.0,
            latitude = 0.0,
            recentCitySearch = "",
            admin1 = ""
        ).longitude
        if (dataSearches is DataSearches.itemSearch) {
            longitude = dataSearches.longitude
        }

        var latitude = DataSearches.itemSearch(
            longitude = 0.0,
            latitude = 0.0,
            recentCitySearch = "",
            admin1 = ""
        ).latitude
        if (dataSearches is DataSearches.itemSearch) {
            latitude = dataSearches.latitude
        }
        weeklyViewModel.getWeekly(latitude!!, longitude!!)
        setupAdapter()
        setupObserver()

        weeklyViewModel.navigateToSearchScreen.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_home_screen_to_search_screen)
                weeklyViewModel.navigateToSearchScreen.postValue(false)
            }
        })

    }

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