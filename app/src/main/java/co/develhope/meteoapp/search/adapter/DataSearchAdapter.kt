package co.develhope.meteoapp.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.databinding.SearchRecyclerviewItemBinding
import co.develhope.meteoapp.search.DataSearches

class DataSearchAdapter(private var dataList: List<DataSearches>) : Adapter<ViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return dataList[position].type
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {

            DataSearches.itemSearch1 -> SearchViewHolder(
                SearchRecyclerviewItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> throw Exception("Invalid View Holder type")

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val searchData = dataList[position]


        when (holder) {

            is SearchViewHolder -> {
                holder.onBind(searchData as DataSearches.itemSearch)
            }
        }


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(newHints: List<DataSearches>) {
        dataList = newHints
        notifyDataSetChanged()
    }
}