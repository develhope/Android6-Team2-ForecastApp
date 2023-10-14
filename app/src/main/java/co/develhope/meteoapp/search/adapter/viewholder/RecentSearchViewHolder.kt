package co.develhope.meteoapp.search.adapter.viewholder

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.databinding.SearchRecyclerviewItemBinding
import co.develhope.meteoapp.search.DataSearches

class RecentSearchViewHolder(val binding: SearchRecyclerviewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun onBind(model: DataSearches.RecentSearch) {
        binding.searchRecentCityItem.text = "${model.citySearch.recentCitySearch}, ${model.citySearch.admin1}"
        binding.root.setOnClickListener {
            Data.saveSearchCity(model)
            binding.root.findNavController().navigate(R.id.action_search_to_home_screen)
        }

    }

}
