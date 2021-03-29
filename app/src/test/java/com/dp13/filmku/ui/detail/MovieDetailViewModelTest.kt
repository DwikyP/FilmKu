package com.dp13.filmku.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {
    private lateinit var viewModel: MovieDetailViewModel
    private val dummyMovie = DataDummy.generatesDummyMovies()[0]
    private val dummyFavMovie = DataDummy.generatesDummyFavoriteMovies()[0]
    private val filmId = dummyMovie.filmId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Mock
    private lateinit var favObserver: Observer<FavoriteMovieEntity>

    @Before
    fun setUp(){
        viewModel = MovieDetailViewModel(filmRepository)
        viewModel.setSelectedMovie(filmId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie
        `when`(filmRepository.getMovie(filmId)).thenReturn(movie)

        val movieEntity = viewModel.getMovie().value as MovieEntity
        verify(filmRepository).getMovie(filmId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.filmId, movieEntity.filmId)
        assertEquals(dummyMovie.posterImg, movieEntity.posterImg)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.year, movieEntity.year)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.imdbRating, movieEntity.imdbRating)
        assertEquals(dummyMovie.plot, movieEntity.plot)
        assertEquals(dummyMovie.actor, movieEntity.actor)
        assertEquals(dummyMovie.director, movieEntity.director)
        assertEquals(dummyMovie.writer, movieEntity.writer)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getFavoriteMovie(){
        val favMovie = MutableLiveData<FavoriteMovieEntity>()
        favMovie.value = dummyFavMovie
        `when`(filmRepository.getFavoriteMovie(filmId)).thenReturn(favMovie)

        val favMovieEntity = viewModel.getFavoriteMovie().value as FavoriteMovieEntity
        verify(filmRepository).getFavoriteMovie(filmId)
        assertNotNull(favMovieEntity)
        assertEquals(dummyFavMovie.filmId, favMovieEntity.filmId)
        assertEquals(dummyFavMovie.posterImg, favMovieEntity.posterImg)
        assertEquals(dummyFavMovie.title, favMovieEntity.title)
        assertEquals(dummyFavMovie.year, favMovieEntity.year)
        assertEquals(dummyFavMovie.plot, favMovieEntity.plot)

        viewModel.getFavoriteMovie().observeForever(favObserver)
        verify(favObserver).onChanged(dummyFavMovie)
    }

    @Test
    fun insertFavoriteMovie(){
        doNothing().`when`(filmRepository).insertFavoriteMovie(dummyFavMovie)
        viewModel.insertFavoriteMovie(dummyFavMovie)
        verify(filmRepository, times(1)).insertFavoriteMovie(dummyFavMovie)
    }

    @Test
    fun deleteFavoriteMovie(){
        doNothing().`when`(filmRepository).deleteFavoriteMovie(dummyFavMovie)
        viewModel.deleteFavoriteMovie(dummyFavMovie)
        verify(filmRepository, times(1)).deleteFavoriteMovie(dummyFavMovie)
    }
}