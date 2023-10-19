package co.develhope.meteoapp.ui.search.adapter


sealed class DataSearches(val type: Int) {

    data class ItemSearch(
        val recentCitySearch: String,
        val admin1: String?,
        val longitude: Double?,
        val latitude: Double?,
        var isSelected: Boolean = false
    ) : DataSearches(
        itemSearchId
    ) {
        override fun toString(): String {
            return "${this.recentCitySearch}, ${this.admin1}"
        }
    }

    data class SearchTitle(val title: String) : DataSearches(searchTitleId)

    data class RecentSearch(val citySearch: ItemSearch) : DataSearches(recentSearchId)


    companion object {
        const val itemSearchId = 1
        const val searchTitleId = 2
        const val recentSearchId = 3
    }

}



