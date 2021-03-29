package com.dp13.filmku.di

import android.content.Context
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.LocalDataSource
import com.dp13.filmku.data.source.local.room.FilmDatabase
import com.dp13.filmku.data.source.remote.RemoteDataSource
import com.dp13.filmku.utils.AppExecutors
import com.dp13.filmku.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): FilmRepository {
        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}