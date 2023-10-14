package co.develhope.meteoapp.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.databinding.RecentSearchTitleBinding
import co.develhope.meteoapp.databinding.SearchRecyclerviewItemBinding
import co.develhope.meteoapp.search.DataSearches
import co.develhope.meteoapp.search.adapter.viewholder.RecentSearchViewHolder
import co.develhope.meteoapp.search.adapter.viewholder.SearchTitleViewHolder
import co.develhope.meteoapp.search.adapter.viewholder.SearchViewHolder


class DataSearchAdapter(var searchList: List<DataSearches>) : Adapter<ViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return searchList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            DataSearches.itemSearchId -> SearchViewHolder(SearchRecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
            DataSearches.searchTitleId -> SearchTitleViewHolder(RecentSearchTitleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
            DataSearches.recentSearchId -> RecentSearchViewHolder(SearchRecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))

            else -> throw Exception("Error: Invalid view holder")
        }
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val search = searchList[position]

        when(holder){
            is SearchViewHolder -> holder.onBind(search as DataSearches.ItemSearch)
            is SearchTitleViewHolder -> holder.onBind(search as DataSearches.SearchTitle)
            is RecentSearchViewHolder -> holder.onBind(search as DataSearches.RecentSearch)
        }
    }


    fun setNewList(newList: List<DataSearches>){
        searchList = newList
        notifyDataSetChanged()
    }


}