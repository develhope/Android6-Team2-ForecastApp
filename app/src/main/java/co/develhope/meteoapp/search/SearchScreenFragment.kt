package co.develhope.meteoapp.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding
import co.develhope.meteoapp.search.adapter.DataSearchAdapter


class SearchScreenFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()

    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter : DataSearchAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       adapter = DataSearchAdapter(requireContext(), mutableListOf())
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

        private fun SearchDataLocal?.toDataSearches(): List<DataSearches> {

            val newList = mutableListOf<DataSearches>()

            this?.forEach {
                val cityName = it.name.toString()
                newList.add(DataSearches.itemSearch(recentCitySearch = cityName))
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