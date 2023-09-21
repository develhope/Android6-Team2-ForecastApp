package co.develhope.meteoapp.home.adapter

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.DataSearches
import co.develhope.meteoapp.databinding.SearchRecyclerviewItemBinding

class SearchViewHolder(val binding: SearchRecyclerviewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun onBind(model: DataSearches.itemSearch) {
        binding.searchRecentCityItem.text = model.recentCitySearch
        binding.searchRecentTemperatureItem.text = model.recentTemperatureSearch
        binding.searchRecentWeatherItem.text = model.recentWeatherSearch
    }


}