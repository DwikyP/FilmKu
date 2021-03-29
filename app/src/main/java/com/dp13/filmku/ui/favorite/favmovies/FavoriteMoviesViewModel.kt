package com.dp13.filmku.ui.favorite.favmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity

class FavoriteMoviesViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getFavoriteMovies(): LiveData<PagedList<FavoriteMovieEntity>> = filmRepository.getFavoriteMovies()
}