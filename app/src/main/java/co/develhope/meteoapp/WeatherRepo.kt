package co.develhope.meteoapp

import co.develhope.meteoapp.data.local.DailyDataLocal
import co.develhope.meteoapp.data.remote.toDailyDataLocal
import co.develhope.meteoapp.network.Module
class WeatherRepo {
    private val weatherService: WeatherService = Module().getRetrofit().create(WeatherService::class.java)

    private val dailyData =
        "temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,rain,weathercode,cloudcover,windspeed_10m,winddirection_10m,uv_index,is_day"

    suspend fun getWeather(
        lat: Double,
        lon: Double
    ): DailyDataLocal? {

        val response = weatherService.getDaily(lat, lon, dailyData, "UTC", 1)

        return response.toDailyDataLocal()
    }
}