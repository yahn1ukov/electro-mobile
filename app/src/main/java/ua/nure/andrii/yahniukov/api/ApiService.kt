package ua.nure.andrii.yahniukov.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ua.nure.andrii.yahniukov.api.services.IAuthenticationApiService
import ua.nure.andrii.yahniukov.api.services.INoAuthenticationApiService
import java.util.concurrent.TimeUnit

fun getNoAuthenticationApiService(): INoAuthenticationApiService {
    return Retrofit.Builder()
        .baseUrl("https://67ed-109-87-8-64.eu.ngrok.io/")
        .addConverterFactory(getConverterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(INoAuthenticationApiService::class.java)
}

fun getAuthenticationApiService(): IAuthenticationApiService {
    return Retrofit.Builder()
        .baseUrl("https://67ed-109-87-8-64.eu.ngrok.io/")
        .addConverterFactory(getConverterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(getOkhttpClient())
        .build()
        .create(IAuthenticationApiService::class.java)
}

private fun getOkhttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val headersInterceptor = HeadersInterceptor()


    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(headersInterceptor)
        .build()
}

private fun getConverterFactory(): Converter.Factory {
    val gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .serializeNulls()
        .setLenient()
        .create()
    return GsonConverterFactory.create(gson)
}