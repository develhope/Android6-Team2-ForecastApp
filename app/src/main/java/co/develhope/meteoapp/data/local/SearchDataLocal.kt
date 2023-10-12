package co.develhope.meteoapp.data.local

import co.develhope.meteoapp.data.remote.SearchDataRemote
import retrofit2.Response

class SearchDataLocal : ArrayList<SearchDataLocal.ResultLocal>() {
    data class ResultLocal(
        val admin1: String?,
        val latitude: Double?,
        val longitude: Double?,
        val name: String?
    )
}

fun Response<SearchDataRemote>.toSearchDataLocal(): SearchDataLocal? {
    return if (this.isSuccessful) {
        val response = this.body()

        val model = SearchDataLocal()


        response?.results?.forEach {
            model.add(
                SearchDataLocal.ResultLocal(
                    admin1 = it?.admin1,
                    latitude = it?.latitude,
                    longitude = it?.longitude,
                    name = it?.name
                )
            )
        }
        model
    } else {
        null
    }
}


