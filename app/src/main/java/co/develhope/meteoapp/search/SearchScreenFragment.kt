package co.develhope.meteoapp.search

import android.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.develhope.meteoapp.data.domain.HourlyForecast
import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding
import co.develhope.meteoapp.search.adapter.DataSearchAdapter
import co.develhope.meteoapp.today.HourlyForecastItems
import org.threeten.bp.OffsetDateTime


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


        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {binding.searchEditText.showDropDown()}
            override fun afterTextChanged(s: Editable) {
                if (!s.isEmpty() && s.length > 3) {
                    searchViewModel.getPlaces(s.toString())

                }
            }
        })

//        binding.searchEditText.addTextChangedListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//
//                if (newText != null) {
//                    if (!newText.isEmpty() && newText.length > 3) {
//                        searchViewModel.getPlaces(newText.toString())
//                    }
//
//                    binding.searchEditText.post {
//                        binding.searchEditText.
//                    }
//                }
//
//
//                val adapter = DataSearchAdapter(emptyList())
//                binding.searchRecyclerView.adapter = adapter
//
//                return true
//            }
//        })
    }


    fun observerSearch() {
        searchViewModel.cityHints.observe(viewLifecycleOwner) {
            it?.let {
                val hints = it
                val adapter = binding.searchRecyclerView.adapter as DataSearchAdapter
                adapter.updateData(hints.toDataSearches())
            }
        }
    }

    private fun SearchDataLocal?.toDataSearches(): List<DataSearches> {

        val newList = mutableListOf<DataSearches>()

        this?.forEach {
            newList.add(DataSearches.itemSearch(recentCitySearch = it.name.toString()))
        }
        return newList
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}