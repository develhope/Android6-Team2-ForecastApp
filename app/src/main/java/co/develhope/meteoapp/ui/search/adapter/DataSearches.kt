package co.develhope.meteoapp.ui.search.adapter


sealed class DataSearches(val type: Int) {

    data class ItemSearch(
        val recentCitySearch: String,
        val admin1: String?,
        val longitude: Double?,
        val latitude: Double?,
    ) : DataSearches(
        itemSearchId
    ) {
        override fun toString(): String {
            return "${this.recentCitySearch}, ${this.admin1}"
        }
    }

    data class SearchTitle(val title: String) : DataSearches(searchTitleId)

    companion object {
        const val itemSearchId = 1
        const val searchTitleId = 2
    }

}




