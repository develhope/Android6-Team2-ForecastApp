package co.develhope.meteoapp.data.domain

import co.develhope.meteoapp.data.domain.SearchDataLocal.ResultLocal
import co.develhope.meteoapp.data.dto.SearchDataRemote
import retrofit2.Response

class SearchDataLocal : ArrayList<ResultLocal>() {
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
                ResultLocal(
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


