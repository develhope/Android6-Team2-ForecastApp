package co.develhope.meteoapp.network

import co.develhope.meteoapp.data.domain.SearchDataLocal
import co.develhope.meteoapp.data.domain.toSearchDataLocal
import javax.inject.Inject

class SearchRepo @Inject constructor(
    private val searchService: SearchService
) {

    suspend fun getSearch(
        cityName : String
    ) : SearchDataLocal? {

        val response = searchService.getSearchCity(cityName, 10, "it")

        return response.toSearchDataLocal()

    }





}