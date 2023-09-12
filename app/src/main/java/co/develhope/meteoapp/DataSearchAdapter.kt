package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.SearchRecyclerviewItemBinding

class DataSearchAdapter(val dataList: List<DataSearch>) :
    RecyclerView.Adapter<DataSearchAdapter.VHDataSearch>() {

    class VHDataSearch(val binding: SearchRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHDataSearch {
        return VHDataSearch(
            SearchRecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VHDataSearch, position: Int) {

        val searchData = dataList[position]
        holder.binding.searchRecentCityItem.text = searchData.recentCitySearch
        holder.binding.searchRecentTemperatureItem.text = searchData.recentTemperatureSearch
        holder.binding.searchRecentWeatherItem.text = searchData.recentWeatherSearch

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}