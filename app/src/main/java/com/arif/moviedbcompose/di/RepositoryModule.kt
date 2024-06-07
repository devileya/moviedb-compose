package com.arif.moviedbcompose.di

import com.arif.moviedbcompose.data.repository.MovieListRepositoryImpl
import com.arif.moviedbcompose.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 14 February 2024
 */
@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

//    @Singleton
//    @Provides
//    fun provideMovieListRepository(impl: MovieListRepositoryImpl) = impl

    @Binds
    @Singleton
    abstract fun bindMovieListRepository(
        movieListRepositoryImpl: MovieListRepositoryImpl
    ): MovieListRepository

}