package co.develhope.meteoapp.search.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.search.DataSearches
import co.develhope.meteoapp.databinding.SearchRecyclerviewItemBinding

class SearchViewHolder(val binding: SearchRecyclerviewItemBinding, val action : (DataSearches.itemSearch) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {


    fun onBind(model: DataSearches.itemSearch) {
        binding.searchRecentCityItem.text = model.recentCitySearch
        binding.searchRecentCityItem.setOnClickListener{
            Log.d("SEARCH VIEW HOLDER", "item clicked $it")
            action(model)
        }
//        binding.searchRecentTemperatureItem.text = model.recentTemperatureSearch
//        binding.searchRecentWeatherItem.text = model.recentWeatherSearch
    }


}