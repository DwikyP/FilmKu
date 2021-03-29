package com.dp13.filmku.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity

class MovieDetailViewModel(val filmRepository: FilmRepository): ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String){
        this.movieId = movieId
    }

    fun getMovie(): LiveData<MovieEntity> = filmRepository.getMovie(movieId)

    fun getFavoriteMovie(): LiveData<FavoriteMovieEntity> = filmRepository.getFavoriteMovie(movieId)

    fun insertFavoriteMovie(favoriteMovie: FavoriteMovieEntity){
        filmRepository.insertFavoriteMovie(favoriteMovie)
    }

    fun deleteFavoriteMovie(favoriteMovie: FavoriteMovieEntity){
        filmRepository.deleteFavoriteMovie(favoriteMovie)
    }
}