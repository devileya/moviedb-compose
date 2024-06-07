package com.arif.moviedbcompose.di

import android.app.Application
import androidx.room.Room
import com.arif.moviedbcompose.data.local.movie.MovieDatabase
import com.arif.moviedbcompose.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 15 February 2024
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Singleton
    @Provides
    fun provideMovieApi(): MovieApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MovieApi.BASE_URL)
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(app, MovieDatabase::class.java, "moviedb.db").build()
    }

}