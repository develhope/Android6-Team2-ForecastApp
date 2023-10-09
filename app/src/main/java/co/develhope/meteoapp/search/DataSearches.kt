package co.develhope.meteoapp.search

sealed class DataSearches(val type: Int) {


    data class itemSearch(
        val recentCitySearch: String,
        val admin1: String?,
        val longitude : Double?,
        val latitude : Double?
    ) : DataSearches(itemSearch1){
        override fun toString(): String {
            return this.recentCitySearch
        }
    }

    companion object {
        const val itemSearch1 = 1
    }

}


