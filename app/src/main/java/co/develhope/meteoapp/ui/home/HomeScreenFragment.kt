package co.develhope.meteoapp.ui.home

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
import co.develhope.meteoapp.data.domain.toWeekItems
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
import co.develhope.meteoapp.ui.home.adapter.WeekAdapter
import co.develhope.meteoapp.ui.search.adapter.DataSearches
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreenFragment : Fragment() {
    private val weeklyViewModel: HomeScreenViewModel by viewModels()
    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO questa logica va spostata nel viewmodel
        val dataSearches = Data.getSearchCity(requireContext())

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

        //TODO la chiamata di rete va sempre eseguita dopo tutti i setup altrimenti rischi di ricevere la risposta dal Be ma non avere l'observer
        // inizializzato o la ui pronta
        weeklyViewModel.getWeekly(latitude!!, longitude!!)
        setupAdapter()
        setupObserver()


        //TODO se c'è una funziona che gestisce gli observer va spostata lì
        weeklyViewModel.navigateToSearchScreen.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.search_screen)
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
            (binding.homeRecyclerView.adapter as WeekAdapter).setNewList(it.toWeekItems(requireContext()))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}