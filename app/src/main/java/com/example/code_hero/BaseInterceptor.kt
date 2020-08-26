package com.example.code_hero

import okhttp3.Interceptor
import okhttp3.Response

class BaseInterceptor : Interceptor {

    companion object {
        const val PUBLIC_KEY = "9a84b6889039db500c250b40e104b070"
        const val HASH = "825389ab214ff3ae12d22e49dbe953c2"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("ts", "1")
            .addQueryParameter("apikey", PUBLIC_KEY)
            .addQueryParameter("hash", HASH)
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)

    }
}