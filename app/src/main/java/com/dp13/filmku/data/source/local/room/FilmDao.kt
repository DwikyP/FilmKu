package com.dp13.filmku.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.data.source.local.entity.TvShowEntity

@Dao
interface FilmDao {
    @Query("SELECT * FROM movies")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshows")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movies WHERE filmId = :filmId")
    fun getMovieById(filmId: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tvshows WHERE filmId = :filmId")
    fun getTvShowById(filmId: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM favoritemovies WHERE filmId = :filmId")
    fun getFavoriteMovieById(filmId: String): LiveData<FavoriteMovieEntity>

    @Query("SELECT * FROM favoritetvshows WHERE filmId = :filmId")
    fun getFavoriteTvShowById(filmId: String): LiveData<FavoriteTvShowEntity>

    @Query("SELECT * FROM favoritemovies")
    fun getFavoriteMovies(): DataSource.Factory<Int, FavoriteMovieEntity>

    @Query("SELECT * FROM favoritetvshows")
    fun getFavoriteTvShows(): DataSource.Factory<Int, FavoriteTvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Insert
    fun insertFavoriteMovie(favoriteMovie: FavoriteMovieEntity)

    @Delete
    fun deleteFavoriteMovie(favoriteMovie: FavoriteMovieEntity)

    @Insert
    fun insertFavoriteTvShow(favoriteMovie: FavoriteTvShowEntity)

    @Delete
    fun deleteFavoriteTvSHow(favoriteMovie: FavoriteTvShowEntity)
}