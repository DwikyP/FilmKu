package com.dp13.filmku.ui.favorite.favtvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity

class FavoriteTvShowsViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getFavoriteTvShows(): LiveData<PagedList<FavoriteTvShowEntity>> = filmRepository.getFavoriteTvShows()
}