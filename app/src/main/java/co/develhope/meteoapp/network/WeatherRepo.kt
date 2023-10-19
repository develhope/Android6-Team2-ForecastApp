package co.develhope.meteoapp.network

import co.develhope.meteoapp.data.domain.DailyDataLocal
import co.develhope.meteoapp.data.domain.WeeklyDataLocal
import co.develhope.meteoapp.data.dto.toDailyDataLocal
import co.develhope.meteoapp.data.dto.toWeeklyDataLocal

class WeatherRepo {

    private val weatherService: WeatherService = Module().getRetrofit().create(WeatherService::class.java)

    private val dailyData =
        "temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,rain,weathercode,cloudcover,windspeed_10m,winddirection_10m,uv_index,is_day"

    private val weeklyData =
        "precipitation_sum,temperature_2m_max,temperature_2m_min,weathercode,windspeed_10m_max"
    suspend fun getWeather(
        lat: Double,
        lon: Double,
        startDate: String,
        endDate: String
    ): DailyDataLocal? {

        val response = weatherService.getDaily(lat, lon, dailyData, "UTC", startDate, endDate)

        return response.toDailyDataLocal()
    }
    suspend fun getHomeWeather(
        lat: Double,
        lon: Double,
    ): WeeklyDataLocal? {

        val response = weatherService.getWeekly(lat, lon, weeklyData,"UTC")

        return response.toWeeklyDataLocal()
    }
}