package co.develhope.meteoapp.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding
import co.develhope.meteoapp.search.adapter.DataSearchAdapter


class SearchScreenFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()

    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: DataSearchAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DataSearchAdapter(requireContext(), mutableListOf()) {
            Data.saveSearchCity(
                SearchDataLocal.ResultLocal(
                admin1 = it.admin1,
                latitude = it.latitude,
                longitude = it.longitude,
                name = it.recentCitySearch
            ))
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            Log.d("CLICKED", "Item Clicked $it")
        }
        binding.searchEditText.setAdapter(adapter)

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!s.isEmpty() && s.length >= 3) {
                    searchViewModel.getPlaces(s.toString())

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
                DataSearches.itemSearch(
                    recentCitySearch = cityName,
                    admin1 = it.admin1,
                    latitude = it.latitude,
                    longitude = it.longitude
                )
            )
        }
        return newList
    }

    fun observerSearch() {
        searchViewModel.cityHints.observe(viewLifecycleOwner) { hints ->
            hints?.let {
                if (::adapter.isInitialized) {
                    adapter.updateData(hints.toDataSearches())
                }
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}