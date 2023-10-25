package co.develhope.meteoapp.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding
import co.develhope.meteoapp.ui.search.adapter.DataSearchAdapter
import co.develhope.meteoapp.ui.search.adapter.DataSearches


class SearchScreenFragment : Fragment() {
    private val searchViewModel: SearchViewModel by activityViewModels()

    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!

    private var selectedSearchItem: DataSearches? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchRecyclerView.adapter = DataSearchAdapter(
            searchList = Data.getRecentSearches(),
            onClick = { model ->
                Data.saveSearchCity(model)
                moveSelectedSearchToTop(model)
                clearAutoCompleteTextView()
                searchViewModel.clearSearch()
                findNavController().navigate(R.id.action_search_to_home)
            }
        )

        observerSearch()

        binding.xIconClick.setOnClickListener {
            clearAutoCompleteTextView()
            Log.d("X ICON CLICKED", "CLICK CLICK CLICK !")
        }

        binding.searchAutoCompleteTextView.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable) {
                    if (s.isEmpty()) {
                        binding.xIconClick.visibility = View.GONE

                        (binding.searchRecyclerView.adapter as? DataSearchAdapter)?.setNewList(Data.getRecentSearches())
                    } else {
                        binding.xIconClick.visibility = View.VISIBLE

                        searchViewModel.getPlaces(s.toString())
                    }
                }
            })
    }

    private fun observerSearch() {
        searchViewModel.cityHints.observe(viewLifecycleOwner) { hints ->
            hints
                ?.toDataSearches()
                ?.let { newList ->
                    (binding.searchRecyclerView.adapter as? DataSearchAdapter)
                        ?.setNewList(newList)
                }
        }
    }

    private fun clearAutoCompleteTextView() {
        binding.searchAutoCompleteTextView.setText("")
        binding.xIconClick.visibility = View.GONE
        (binding.searchRecyclerView.adapter as? DataSearchAdapter)?.setNewList(Data.getRecentSearches())
    }

    private fun moveSelectedSearchToTop(selectedItem: DataSearches) {
        Data.moveSearchToTop(selectedItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

