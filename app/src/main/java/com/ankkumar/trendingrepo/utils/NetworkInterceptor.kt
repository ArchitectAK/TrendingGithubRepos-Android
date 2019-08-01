package com.ankkumar.trendingrepo.utils


import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

abstract class NetworkInterceptor : Interceptor {

    abstract val isInternetAvailable: Boolean

    abstract fun onInternetUnavailable()


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (!isInternetAvailable) {
            onInternetUnavailable()
        }
        return chain.proceed(request)
    }
}