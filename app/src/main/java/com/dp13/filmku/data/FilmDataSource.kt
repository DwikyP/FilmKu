package com.dp13.filmku.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.vo.Resource

interface FilmDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMovie(filmId: String): LiveData<MovieEntity>

    fun getTvShow(filmId: String): LiveData<TvShowEntity>

    fun getFavoriteMovie(filmId: String): LiveData<FavoriteMovieEntity>

    fun getFavoriteTvShow(filmId: String): LiveData<FavoriteTvShowEntity>

    fun getFavoriteMovies(): LiveData<PagedList<FavoriteMovieEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<FavoriteTvShowEntity>>

    fun insertFavoriteMovie(favoriteMovie: FavoriteMovieEntity)

    fun deleteFavoriteMovie(favoriteMovie: FavoriteMovieEntity)

    fun insertFavoriteTvShow(favoriteTvShow: FavoriteTvShowEntity)

    fun deleteFavoriteTvShow(favoriteTvShow: FavoriteTvShowEntity)
}