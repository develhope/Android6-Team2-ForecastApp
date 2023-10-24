package co.develhope.meteoapp.ui.search.adapter.viewholder

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.SearchRecyclerviewItemBinding
import co.develhope.meteoapp.ui.search.SearchScreenFragment
import co.develhope.meteoapp.ui.search.adapter.DataSearches


class SearchViewHolder(
    private val binding: SearchRecyclerviewItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(model: DataSearches.ItemSearch, fragment: SearchScreenFragment) {
        binding.searchRecentCityItem.text = "${model.recentCitySearch}, ${model.admin1}"
        binding.root.setOnClickListener {
            Data.saveSearchCity(model)
                binding.root.findNavController().navigate(R.id.action_search_to_home)
                fragment.clearAutoCompleteTextView()
        }
    }

}