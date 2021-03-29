package com.dp13.filmku.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource = INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getMovies()

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getTvShows()

    fun getMovie(filmId: String): LiveData<MovieEntity> = mFilmDao.getMovieById(filmId)

    fun getTvShow(filmId: String): LiveData<TvShowEntity> = mFilmDao.getTvShowById(filmId)

    fun getFavoriteMovie(filmId: String): LiveData<FavoriteMovieEntity> = mFilmDao.getFavoriteMovieById(filmId)

    fun getFavoriteTvShow(filmId: String): LiveData<FavoriteTvShowEntity> = mFilmDao.getFavoriteTvShowById(filmId)

    fun getFavoriteMovies(): DataSource.Factory<Int, FavoriteMovieEntity> = mFilmDao.getFavoriteMovies()

    fun getFavoriteTvShows(): DataSource.Factory<Int, FavoriteTvShowEntity> = mFilmDao.getFavoriteTvShows()

    fun insertMovies(movies: List<MovieEntity>) = mFilmDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mFilmDao.insertTvShows(tvShows)

    fun insertFavoriteMovie(favoriteMovie: FavoriteMovieEntity) =
        mFilmDao.insertFavoriteMovie(favoriteMovie)

    fun deleteFavoriteMovie(favoriteMovie: FavoriteMovieEntity) =
        mFilmDao.deleteFavoriteMovie(favoriteMovie)

    fun insertFavoriteTvShow(favoriteTvShow: FavoriteTvShowEntity) =
        mFilmDao.insertFavoriteTvShow(favoriteTvShow)

    fun deleteFavoriteTvShow(favoriteTvShow: FavoriteTvShowEntity) =
        mFilmDao.deleteFavoriteTvSHow(favoriteTvShow)

}

