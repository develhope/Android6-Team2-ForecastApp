package co.develhope.meteoapp.search

sealed class DataSearches {

    data class itemSearch(val recentCitySearch: String, val admin1: String?, val longitude : Double?, val latitude : Double?) : DataSearches(){ override fun toString(): String {
            return "${this.recentCitySearch}, ${this.admin1}" } }

}


