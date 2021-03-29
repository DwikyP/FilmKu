package com.dp13.filmku.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dp13.filmku.data.source.remote.response.MovieResponse
import com.dp13.filmku.data.source.remote.response.TvShowResponse
import com.dp13.filmku.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(helper)
                }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())

        return resultMovies
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowResponse>>>{
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        resultTvShows.value = ApiResponse.success(jsonHelper.loadTvShows())

        return resultTvShows
    }


}