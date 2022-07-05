package ua.nure.andrii.yahniukov.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HeadersInterceptor : Interceptor {
    private val prefs = AppPrefs()

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val accessToken = prefs.getToken()
        builder.apply {
            addHeader("Authorization", "Bearer $accessToken")
            addHeader("Content-Type", "application/json")
            addHeader("Cache-Control", "no-cache")
        }
        return chain.proceed(builder.build())
    }
}