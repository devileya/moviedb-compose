package com.arif.moviedbcompose.data.local.movie

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Github https://github.com/devileya/
 * Created by Arif Fadly Siregar
 * Created at 13 February 2024
 */
@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao
}