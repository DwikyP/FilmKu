package com.dp13.filmku.ui.favorite.favtvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowsViewModelTest{
    private lateinit var viewModel: FavoriteTvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FavoriteTvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<FavoriteTvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTvShowsViewModel(filmRepository)
    }

    @Test
    fun getFavoriteTvShows() {
        val dummyFavTvShows = pagedList
        `when`(dummyFavTvShows.size).thenReturn(5)
        val favTvShows = MutableLiveData<PagedList<FavoriteTvShowEntity>>()
        favTvShows.value = dummyFavTvShows

        Mockito.`when`(filmRepository.getFavoriteTvShows()).thenReturn(favTvShows)
        val favTvShowsEntities = viewModel.getFavoriteTvShows().value
        Mockito.verify<FilmRepository>(filmRepository).getFavoriteTvShows()
        assertNotNull(favTvShowsEntities)
        assertEquals(5, favTvShowsEntities?.size)

        viewModel.getFavoriteTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyFavTvShows)
    }
}