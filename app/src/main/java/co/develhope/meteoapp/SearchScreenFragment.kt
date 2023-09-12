package co.develhope.meteoapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.databinding.FragmentSearchScreenBinding

class SearchScreenFragment : Fragment() {

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


        val searchAdapterData = listOf<DataSearches>(
            DataSearches("Palermo", "14°", "soleggiato"),
            DataSearches("Agrigento", "16°", "parz. nuvoloso"),
            DataSearches("Catania", "20°", "soleggiato"),
            DataSearches("Siracusa", "12°", "pioggia"),
        )

        val adapter = DataSearchAdapter(searchAdapterData)
        binding.searchRecyclerView.adapter = adapter

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val cityName = s.toString()
                // Avvia il TodayScreenFragment passando il nome della città
                val action = R.id.today_screen
                findNavController().navigate(action)
            }
        })


    }


    override fun onResume() {
        super.onResume()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}