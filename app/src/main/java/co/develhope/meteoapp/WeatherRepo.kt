package co.develhope.meteoapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object WeatherRepo {

    var weatherService: WeatherService? = null

    var dailyData = "temperature_2m,relativehumidity_2m,windspeed_10m"

    suspend fun getWeather(): Response<DailyData>? {
        if (weatherService == null){
            weatherService = createRetrofitInstance().create(WeatherService::class.java)
        }

        return weatherService?.getDaily(41.8919,12.5113, dailyData,"GMT",1)
    }



    private fun createRetrofitInstance(): Retrofit{
        val baseUrl = "https://api.open-meteo.com/"
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}