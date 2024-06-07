package com.arif.moviedbcompose.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.arif.moviedbcompose.data.remote.MovieApi.Companion.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 13 February 2024
 */
//@InstallIn(SingletonComponent::class)
//@Module
//class NetworkModule {
//
//    @Provides
//    @Singleton
//    fun providesRetrofit(
//        gsonConverterFactory: GsonConverterFactory,
//        okHttpClient: OkHttpClient
//    ): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(gsonConverterFactory)
//            .client(okHttpClient)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun providesOkHttpClient(
//        @ApplicationContext context: Context
//    ): OkHttpClient {
//        val cacheSize = (5 * 1024 * 1024).toLong()
//        val mCache = Cache(context.cacheDir, cacheSize)
//        val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
//        val client = OkHttpClient.Builder()
//            .cache(mCache) // make your app offline-friendly without a database!
//            .connectTimeout(10, TimeUnit.SECONDS)
//            .writeTimeout(10, TimeUnit.SECONDS)
//            .readTimeout(10, TimeUnit.SECONDS)
//            .addNetworkInterceptor(interceptor)
//            .addInterceptor { chain ->
//                val original = chain.request()
//                val requestBuilder = original.newBuilder()
//                    .header("Accept", "application/vnd.github+json")
//                    .header("Content-Type", "application/json")
//                chain.proceed(requestBuilder.build())
//            }
//        return client.build()
//    }
//
//    @Provides
//    @Singleton
//    fun providesGson(): Gson {
//        return Gson()
//    }
//
//    @Provides
//    @Singleton
//    fun providesGsonConverterFactory(): GsonConverterFactory {
//        return GsonConverterFactory.create()
//    }
//
//    @Provides
//    @Singleton
//    fun provideIsNetworkAvailable(@ApplicationContext context: Context): Boolean {
//        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val nw = connectivityManager.activeNetwork ?: return false
//        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
//        return when {
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//            //for other device how are able to connect with Ethernet
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//            //for check internet over Bluetooth
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
//            else -> false
//        }
//    }
//}