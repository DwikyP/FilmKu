package com.dp13.filmku.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.vo.Resource

class MoviesViewModel(val filmRepository: FilmRepository): ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getAllMovies()
}