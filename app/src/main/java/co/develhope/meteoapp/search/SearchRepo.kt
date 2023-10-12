package co.develhope.meteoapp.search

import co.develhope.meteoapp.data.local.SearchDataLocal
import co.develhope.meteoapp.data.local.toSearchDataLocal
import co.develhope.meteoapp.network.Module

class SearchRepo {

    private val searchService : SearchService = Module().getSearchRetrofit().create(SearchService::class.java)

    suspend fun getSearch(
        cityName : String
    ) : SearchDataLocal? {

        val response = searchService.getSearchCity(cityName, 5, "it")

        return response.toSearchDataLocal()

    }





}