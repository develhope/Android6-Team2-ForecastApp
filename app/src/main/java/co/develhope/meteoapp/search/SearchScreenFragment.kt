package co.develhope.meteoapp.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding
import co.develhope.meteoapp.search.adapter.DataSearchAdapter


class SearchScreenFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()

    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recentSearches = Data.getRecentSearches()
        binding.searchRecyclerView.adapter = DataSearchAdapter(recentSearches)


//        // This is my search adapter.
//        adapter = ArrayAdapter<DataSearches>(
//            requireContext(),
//            android.R.layout.simple_dropdown_item_1line,
//            mutableListOf()
//        )
//        binding.searchEditText.setAdapter(adapter)


        // Click listener for taking the position and save data network in a local data.
//        binding.searchEditText.onItemClickListener =
//            AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
//                val item: DataSearches? = adapter.getItem(p2)
//                Data.saveSearchCity(item)
//                findNavController().navigate(R.id.action_search_to_home_screen)
//                Log.d("DATA SAVED", "Success: $item")
//            }


        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!s.isEmpty() && s.length >= 3) {
                    searchViewModel.getPlaces(s.toString())
                    setUpAdapter()
                    observerSearch()
                }
            }
        })

        observerSearch()
    }


    private fun SearchDataLocal?.toDataSearches(): List<DataSearches> {
        val newList = mutableListOf<DataSearches>()
        this?.forEach {
            val cityName = it.name.toString()
            newList.add(
                DataSearches.ItemSearch(
                    recentCitySearch = cityName,
                    admin1 = it.admin1,
                    latitude = it.latitude,
                    longitude = it.longitude
                )
            )

        }
        return newList
    }


    fun setUpAdapter() {
        binding.searchRecyclerView.adapter = DataSearchAdapter(listOf())
    }


    fun observerSearch() {
        searchViewModel.cityHints.observe(viewLifecycleOwner) { hints ->
            (binding.searchRecyclerView.adapter as DataSearchAdapter).setNewList(hints.toDataSearches())
//            hints?.let {
//                if (::adapter.isInitialized) {
//                    adapter.addAll(hints.toDataSearches())
//                }
        }
    }



override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}

}

