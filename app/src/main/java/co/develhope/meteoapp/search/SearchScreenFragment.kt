package co.develhope.meteoapp.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding



class SearchScreenFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()

    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ArrayAdapter<DataSearches>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArrayAdapter<DataSearches>(requireContext(), android.R.layout.simple_dropdown_item_1line, mutableListOf())
        binding.searchEditText.setAdapter(adapter)
        binding.searchEditText.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("CIAO", "ECCOMI QUA $position")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

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
                    adapter.addAll(hints.toDataSearches())
                }
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}