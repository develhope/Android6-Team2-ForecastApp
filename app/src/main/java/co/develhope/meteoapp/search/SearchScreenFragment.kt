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
import co.develhope.meteoapp.WeatherService
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchScreenFragment : Fragment() {

    private val searchViewModel : SearchViewModel by viewModels()

    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!

    private val searchEditText  = binding.searchEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.searchVector.setOnClickListener {
        }

        val adapter = DataSearchAdapter(emptyList())
        binding.searchRecyclerView.adapter = adapter

    }























    override fun onResume() {
        super.onResume()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}