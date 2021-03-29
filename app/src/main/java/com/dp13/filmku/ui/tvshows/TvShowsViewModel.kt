package com.dp13.filmku.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.vo.Resource

class TvShowsViewModel(val filmRepository: FilmRepository): ViewModel() {
    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = filmRepository.getAllTvShows()
}