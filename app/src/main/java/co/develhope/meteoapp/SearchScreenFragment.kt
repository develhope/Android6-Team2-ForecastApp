package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.develhope.meteoapp.databinding.FragmentHomeScreenBinding
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


        val searchAdapterData = listOf<DataSearch>(
            DataSearch("Palermo", "14°", "soleggiato"),
            DataSearch("Agrigento", "16°", "parz. nuvoloso"),
            DataSearch("Catania", "20°", "soleggiato"),
            DataSearch("Siracusa", "12°", "pioggia"),
        )

        binding.searchRecyclerView.adapter = DataSearchAdapter(searchAdapterData)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}