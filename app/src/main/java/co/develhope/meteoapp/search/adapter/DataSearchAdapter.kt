//package co.develhope.meteoapp.search.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.Filter
//import android.widget.Filterable
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//import co.develhope.meteoapp.databinding.SearchRecyclerviewItemBinding
//import co.develhope.meteoapp.search.DataSearches
//
//
//class DataSearchAdapter(
//    context: Context,
//    private val dataList: MutableList<DataSearches>, private val onItemClick : (DataSearches.itemSearch) -> Unit
//) : ArrayAdapter<DataSearches>(context, android.R.layout.simple_dropdown_item_1line, dataList),
//    Filterable {
//    private val originalData: List<DataSearches> = dataList.toList()
//    private var filteredData: List<DataSearches> = dataList.toList()
//
//    override fun getItemViewType(position: Int): Int {
//        return dataList[position].type
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return when (viewType) {
//
//            DataSearches.itemSearch1 -> SearchViewHolder(
//                SearchRecyclerviewItemBinding.inflate(
//                    LayoutInflater.from(parent.context), parent, false
//                )
//            ){ itemClicked ->
//                onItemClick(itemClicked)
//            }
//
//            else -> throw Exception("Invalid View Holder type")
//
//        }
//    }
//
//   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        val searchData = dataList[position]
//        when (holder) {
//            is SearchViewHolder -> {
//                holder.onBind(searchData as DataSearches.itemSearch)
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return dataList.size
//    }
//
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val results = FilterResults()
//                val query = constraint?.toString()?.trim() ?: ""
//
//                if (query.length >= 3) {
//                    filteredData = originalData
//                } else {
//                    // Filtriamo i dati in base al testo di ricerca.
//                    filteredData = originalData.filterIsInstance<DataSearches.itemSearch>().filter {
//                        it.type == 1 && it.recentCitySearch.contains(query, ignoreCase = true)
//                    }
//                }
//
//                results.values = filteredData
//                results.count = filteredData.size
//                return results
//            }
//
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                if (results != null && results.count > 0) {
//                    notifyDataSetChanged()
//                } else {
//                    notifyDataSetInvalidated()
//                }
//            }
//        }
//    }
//
//
//    fun updateData(newHints: List<DataSearches>) {
//        dataList.clear()
//        dataList.addAll(newHints)
//        notifyDataSetChanged()
//    }
//}