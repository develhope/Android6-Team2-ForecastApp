package co.develhope.meteoapp.search.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.RecentSearchTitleBinding
import co.develhope.meteoapp.search.DataSearches

class SearchTitleViewHolder(val binding: RecentSearchTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {



        fun onBind(model: DataSearches.SearchTitle){
            binding.recentSearchTitle.text = model.title
        }

}