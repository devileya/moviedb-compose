package com.arif.moviedbcompose.di

import com.arif.moviedbcompose.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 14 February 2024
 */
//@InstallIn(SingletonComponent::class)
//@Module
//class ServiceModule {
//
//    @Provides
//    @Singleton
//    fun providesMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)
//}