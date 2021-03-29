package com.dp13.filmku.ui.favorite.favmovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dp13.filmku.data.FilmRepository
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.utils.DataDummy
import com.dp13.filmku.vo.Resource
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
class FavoriteMoviesViewModelTest{
    private lateinit var viewModel: FavoriteMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FavoriteMovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<FavoriteMovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMoviesViewModel(filmRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavMovies = pagedList
        `when`(dummyFavMovies.size).thenReturn(5)
        val favMovies = MutableLiveData<PagedList<FavoriteMovieEntity>>()
        favMovies.value = dummyFavMovies

        Mockito.`when`(filmRepository.getFavoriteMovies()).thenReturn(favMovies)
        val favMovieEntities = viewModel.getFavoriteMovies().value
        Mockito.verify<FilmRepository>(filmRepository).getFavoriteMovies()
        assertNotNull(favMovieEntities)
        assertEquals(5, favMovieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyFavMovies)
    }

}