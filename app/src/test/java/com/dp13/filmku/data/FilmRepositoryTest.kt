package com.dp13.filmku.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dp13.filmku.data.source.local.LocalDataSource
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.data.source.remote.RemoteDataSource
import com.dp13.filmku.utils.AppExecutors
import com.dp13.filmku.utils.DataDummy
import com.dp13.filmku.utils.LiveDataTestUtil
import com.dp13.filmku.utils.PagedListUtil
import com.dp13.filmku.vo.Resource
import org.junit.Test

import org.junit.Assert.*

import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.*

class FilmRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val filmRepository = FakeFilmRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].filmId
    private val tvShowResponses = DataDummy.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponses[0].filmId
    private val dummyFavMovie = DataDummy.generatesDummyFavoriteMovies()[0]
    private val dummyFavTvShow = DataDummy.generateDummyFavoriteTvShows()[0]

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generatesDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        filmRepository.getAllTvShows()

        val tvShowEntities =  Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.generatesDummyMovies()[0]
        `when`(local.getMovie(movieId)).thenReturn(dummyMovie)

        val resultMovie = LiveDataTestUtil.getValue(filmRepository.getMovie(movieId))
        verify(local).getMovie(movieId)
        assertNotNull(resultMovie)
        assertNotNull(resultMovie.title)
        assertEquals(movieResponses[0].title, resultMovie.title)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = DataDummy.generateDummyTvShows()[0]
        `when`(local.getTvShow(tvShowId)).thenReturn(dummyTvShow)

        val resultTvShow = LiveDataTestUtil.getValue(filmRepository.getTvShow(tvShowId))
        verify(local).getTvShow(tvShowId)
        assertNotNull(resultTvShow)
        assertNotNull(resultTvShow.title)
        assertEquals(tvShowResponses[0].title, resultTvShow.title)
    }

    @Test
    fun getFavoriteMovies(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteMovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteMovies()

        val favMovieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generatesDummyFavoriteMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(favMovieEntities)
        assertEquals(movieResponses.size.toLong(), favMovieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteTvShowEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteTvShows()

        val favTvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyFavoriteTvShows()))
        verify(local).getFavoriteTvShows()
        assertNotNull(favTvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), favTvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteMovie(){
        val dummyFavMovie = MutableLiveData<FavoriteMovieEntity>()
        dummyFavMovie.value = DataDummy.generatesDummyFavoriteMovies()[0]
        `when`(local.getFavoriteMovie(movieId)).thenReturn(dummyFavMovie)

        val resultFavMovie = LiveDataTestUtil.getValue(filmRepository.getFavoriteMovie(movieId))
        verify(local).getFavoriteMovie(movieId)
        assertNotNull(resultFavMovie)
        assertNotNull(resultFavMovie.title)
        assertEquals(movieResponses[0].title, resultFavMovie.title)
    }

    @Test
    fun getFavoriteTvShow(){
        val dummyFavTvShow = MutableLiveData<FavoriteTvShowEntity>()
        dummyFavTvShow.value = DataDummy.generateDummyFavoriteTvShows()[0]
        `when`(local.getFavoriteTvShow(tvShowId)).thenReturn(dummyFavTvShow)

        val resultFavTvShow = LiveDataTestUtil.getValue(filmRepository.getFavoriteTvShow(tvShowId))
        verify(local).getFavoriteTvShow(tvShowId)
        assertNotNull(resultFavTvShow)
        assertNotNull(resultFavTvShow.title)
        assertEquals(tvShowResponses[0].title, resultFavTvShow.title)
    }

    @Test
    fun insertFavoriteMovie(){
        doNothing().`when`(local).insertFavoriteMovie(dummyFavMovie)
        filmRepository.insertFavoriteMovie(dummyFavMovie)
        Mockito.verify(local, times(1)).insertFavoriteMovie(dummyFavMovie)
    }

    @Test
    fun deleteFavoriteMovie(){
        doNothing().`when`(local).deleteFavoriteMovie(dummyFavMovie)
        filmRepository.deleteFavoriteMovie(dummyFavMovie)
        Mockito.verify(local, times(1)).deleteFavoriteMovie(dummyFavMovie)
    }

    @Test
    fun insertFavoriteTvShow(){
        doNothing().`when`(local).insertFavoriteTvShow(dummyFavTvShow)
        filmRepository.insertFavoriteTvShow(dummyFavTvShow)
        Mockito.verify(local, times(1)).insertFavoriteTvShow(dummyFavTvShow)
    }

    @Test
    fun deleteFavoriteTvShow(){
        doNothing().`when`(local).deleteFavoriteTvShow(dummyFavTvShow)
        filmRepository.deleteFavoriteTvShow(dummyFavTvShow)
        Mockito.verify(local, times(1)).deleteFavoriteTvShow(dummyFavTvShow)
    }
}