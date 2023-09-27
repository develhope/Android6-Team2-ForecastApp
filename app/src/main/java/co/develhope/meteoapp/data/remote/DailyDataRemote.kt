package co.develhope.meteoapp.data.remote
import android.os.Build
import androidx.annotation.RequiresApi
import co.develhope.meteoapp.data.local.DailyDataLocal
import com.google.gson.annotations.SerializedName
import org.threeten.bp.LocalDateTime
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter
import retrofit2.Response


data class DailyDataRemote(
    @SerializedName("elevation")
    val elevation: Int?,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerializedName("hourly")
    val hourly: Hourly?,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
) {

    data class Hourly(
        @SerializedName("apparent_temperature")
        val apparentTemperature: List<Double?>?,
        @SerializedName("cloudcover")
        val cloudcover: List<Int?>?,
        @SerializedName("precipitation_probability")
        val precipitationProbability: List<Int?>?,
        @SerializedName("rain")
        val rain: List<Double?>?,
        @SerializedName("relativehumidity_2m")
        val relativehumidity2m: List<Int?>?,
        @SerializedName("temperature_2m")
        val temperature2m: List<Double?>?,
        @SerializedName("time")
        val time: List<String?>?,
        @SerializedName("uv_index")
        val uvIndex: List<Double?>?,
        @SerializedName("weathercode")
        val weathercode: List<Int?>?,
        @SerializedName("winddirection_10m")
        val winddirection10m: List<Int?>?,
        @SerializedName("windspeed_10m")
        val windspeed10m: List<Double?>?,
        @SerializedName("is_day")
        val isDay: List<Int?>?
    )

    data class HourlyUnits(
        @SerializedName("apparent_temperature")
        val apparentTemperature: String?,
        @SerializedName("cloudcover")
        val cloudcover: String?,
        @SerializedName("precipitation_probability")
        val precipitationProbability: String?,
        @SerializedName("rain")
        val rain: String?,
        @SerializedName("relativehumidity_2m")
        val relativehumidity2m: String?,
        @SerializedName("temperature_2m")
        val temperature2m: String?,
        @SerializedName("time")
        val time: String?,
        @SerializedName("uv_index")
        val uvIndex: String?,
        @SerializedName("weathercode")
        val weathercode: String?,
        @SerializedName("winddirection_10m")
        val winddirection10m: String?,
        @SerializedName("windspeed_10m")
        val windspeed10m: String?
    )

}

fun Response<DailyDataRemote>.toDailyDataLocal(): DailyDataLocal? {
    return if(this.isSuccessful){
        val response = this.body()

        val model = DailyDataLocal()


        response?.hourly?.time?.forEachIndexed { index, s ->
            model.add(
                DailyDataLocal.HourlyLocal(
                    apparentTemperature = response.hourly.apparentTemperature?.getOrNull(index),
                    cloudCover = response.hourly.cloudcover?.getOrNull(index),
                    rainChance = response.hourly.precipitationProbability?.getOrNull(index),
                    humidity = response.hourly.relativehumidity2m?.getOrNull(index),
                    uvIndex = response.hourly.uvIndex?.getOrNull(index),
                    rain = response.hourly.rain?.getOrNull(index),
                    temperature2m = response.hourly.temperature2m?.getOrNull(index),
                    time = LocalDateTime.parse(s).atZone(ZoneOffset.UTC).toOffsetDateTime(),
                    weathercode = response.hourly.weathercode?.getOrNull(index),
                    windSpeed = response.hourly.windspeed10m?.getOrNull(index),
                    windDirection = response.hourly.winddirection10m?.getOrNull(index),
                    isDay = response.hourly.isDay?.getOrNull(index)
                )
            )
        }
        model
    } else {
        null
    }
}