package co.develhope.meteoapp.search

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.WeatherService
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding

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


//        fun getHintText(){
//            searchViewModel.getHintText()
//        }

        searchViewModel.getHintText()


        val adapter = DataSearchAdapter(listOf())
        binding.searchRecyclerView.adapter = adapter

    }


//    private fun observeData(){
//        searchViewModel.cityHints.observe(viewLifecycleOwner){
//            binding.searchRecyclerView.adapter = DataSearchAdapter(it?.results)
//        }
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}