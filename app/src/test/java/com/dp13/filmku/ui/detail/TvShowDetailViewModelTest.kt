package com.dp13.filmku.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowDetailViewModelTest {
    private lateinit var viewModel: TvShowDetailViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val dummyFavTvShow = DataDummy.generateDummyFavoriteTvShows()[0]
    private val filmId = dummyTvShow.filmId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<TvShowEntity>

    @Mock
    private lateinit var favObserver: Observer<FavoriteTvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowDetailViewModel(filmRepository)
        viewModel.setSelectedTvShow(filmId)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        Mockito.`when`(filmRepository.getTvShow(filmId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value as TvShowEntity
        Mockito.verify(filmRepository).getTvShow(filmId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.filmId, tvShowEntity.filmId)
        assertEquals(dummyTvShow.posterImg, tvShowEntity.posterImg)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.year, tvShowEntity.year)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
        assertEquals(dummyTvShow.imdbRating, tvShowEntity.imdbRating)
        assertEquals(dummyTvShow.plot, tvShowEntity.plot)
        assertEquals(dummyTvShow.actor, tvShowEntity.actor)
        assertEquals(dummyTvShow.creator, tvShowEntity.creator)
        assertEquals(dummyTvShow.status, tvShowEntity.status)
        assertEquals(dummyTvShow.totalEpisodes, tvShowEntity.totalEpisodes)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }

    @Test
    fun getFavoriteTvShow(){
        val favTvShow = MutableLiveData<FavoriteTvShowEntity>()
        favTvShow.value = dummyFavTvShow
        Mockito.`when`(filmRepository.getFavoriteTvShow(filmId)).thenReturn(favTvShow)

        val favTvShowEntity = viewModel.getFavoriteTvShow().value as FavoriteTvShowEntity
        Mockito.verify(filmRepository).getFavoriteTvShow(filmId)
        assertNotNull(favTvShowEntity)
        assertEquals(dummyFavTvShow.filmId, favTvShowEntity.filmId)
        assertEquals(dummyFavTvShow.posterImg, favTvShowEntity.posterImg)
        assertEquals(dummyFavTvShow.title, favTvShowEntity.title)
        assertEquals(dummyFavTvShow.year, favTvShowEntity.year)
        assertEquals(dummyFavTvShow.plot, favTvShowEntity.plot)
        assertEquals(dummyFavTvShow.status, favTvShowEntity.status)
        assertEquals(dummyFavTvShow.totalEpisodes, favTvShowEntity.totalEpisodes)

        viewModel.getFavoriteTvShow().observeForever(favObserver)
        Mockito.verify(favObserver).onChanged(dummyFavTvShow)
    }

    @Test
    fun insertFavoriteTvShow(){
        Mockito.doNothing().`when`(filmRepository).insertFavoriteTvShow(dummyFavTvShow)
        viewModel.insertFavoriteTvShow(dummyFavTvShow)
        Mockito.verify(filmRepository, Mockito.times(1)).insertFavoriteTvShow(dummyFavTvShow)
    }

    @Test
    fun deleteFavoriteTvShow(){
        Mockito.doNothing().`when`(filmRepository).deleteFavoriteTvShow(dummyFavTvShow)
        viewModel.deleteFavoriteTvShow(dummyFavTvShow)
        Mockito.verify(filmRepository, Mockito.times(1)).deleteFavoriteTvShow(dummyFavTvShow)
    }
}