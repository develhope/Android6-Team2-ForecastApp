package co.develhope.meteoapp


import com.google.gson.annotations.SerializedName

data class Hourly(
    @SerializedName("rain")
    val rain: List<Any?>?,
    @SerializedName("showers")
    val showers: List<Any?>?,
    @SerializedName("snowfall")
    val snowfall: List<Any?>?,
    @SerializedName("temperature_2m")
    val temperature2m: List<Any?>?,
    @SerializedName("time")
    val time: List<String?>?,
    @SerializedName("weathercode")
    val weathercode: List<Any?>?,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Any?>?
)