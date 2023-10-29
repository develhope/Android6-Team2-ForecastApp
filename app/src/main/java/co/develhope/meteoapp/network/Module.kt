package co.develhope.meteoapp.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.OffsetDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Module() {
    fun getRetrofit(): Retrofit {
        return provideRetrofit(
            client = provideOkHttpClient(provideHttpLoggingInterceptor(), TryCatchInterceptor()),
            gson = provideGson()
        )
    }

    fun getSearchRetrofit(): Retrofit {
        return provideSearchRetrofit(
            client = provideOkHttpClient(provideHttpLoggingInterceptor(), TryCatchInterceptor()),
            gson = provideGson()
        )
    }

    private fun provideGson(): Gson = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeTypeAdapter())
        .create()


    private fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    private fun provideSearchRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://geocoding-api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }


    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    private fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        tryCatchInterceptor: TryCatchInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(tryCatchInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    class TryCatchInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            return try {
                chain.proceed(chain.request())
            } catch (e: Exception) {
                Response.Builder()
                    .code(418)
                    .message("Errore di rete")
                    .protocol(Protocol.HTTP_1_1)
                    .request(chain.request())
                    .body(ByteArray(0).toResponseBody(null))
                    .build()
            }
        }
    }
}