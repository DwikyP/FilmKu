package com.dp13.filmku.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.data.source.local.entity.TvShowEntity

class TvShowDetailViewModel(val filmRepository: FilmRepository): ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getTvShow(): LiveData<TvShowEntity> = filmRepository.getTvShow(tvShowId)

    fun getFavoriteTvShow(): LiveData<FavoriteTvShowEntity> = filmRepository.getFavoriteTvShow(tvShowId)

    fun insertFavoriteTvShow(favoriteTvShow: FavoriteTvShowEntity){
        filmRepository.insertFavoriteTvShow(favoriteTvShow)
    }

    fun deleteFavoriteTvShow(favoriteTvShow: FavoriteTvShowEntity){
        filmRepository.deleteFavoriteTvShow(favoriteTvShow)
    }
}