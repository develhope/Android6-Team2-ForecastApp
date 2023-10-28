package co.develhope.meteoapp.network

import co.develhope.meteoapp.data.domain.SearchDataLocal
import co.develhope.meteoapp.data.domain.toSearchDataLocal

class SearchRepo {

    private val searchService : SearchService = Module().getSearchRetrofit().create(SearchService::class.java)

    suspend fun getSearch(
        cityName : String
    ) : SearchDataLocal? {

        val response = searchService.getSearchCity(cityName, 10, "it")

        return response.toSearchDataLocal()

    }





}