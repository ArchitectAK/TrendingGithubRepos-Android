package com.ankkumar.trendingrepo.di

import android.content.Context
import com.ankkumar.trendingrepo.retrofit.APIService
import com.ankkumar.trendingrepo.utils.CheckNetwork
import com.ankkumar.trendingrepo.utils.NetworkException
import com.ankkumar.trendingrepo.utils.NetworkInterceptor
import com.ankkumar.trendingrepo.utils.Utils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideGson(context: Context): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Utils.BASE_URL)
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient {
        val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)

        client.addInterceptor(logging)

        client.addInterceptor((object : NetworkInterceptor() {
            override val isInternetAvailable: Boolean
                get() = CheckNetwork.isNetworkConnected(context)

            override fun onInternetUnavailable() {
                throw NetworkException()
            }
        }))


        return client.build()
    }


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }


}