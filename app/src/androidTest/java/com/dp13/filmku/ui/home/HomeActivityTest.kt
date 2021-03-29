package com.dp13.filmku.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dp13.filmku.R
import com.dp13.filmku.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HomeActivityTest{
    private val dummyMovies = DataDummy.generatesDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvShows()

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadTvShows(){
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadMovieDetail(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_movie_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_title)).check((matches(withText(dummyMovies[0].title))))
        onView(withId(R.id.tv_movie_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_year)).check((matches(withText("(${dummyMovies[0].year})"))))
        onView(withId(R.id.tv_movie_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_genre)).check((matches(withText(dummyMovies[0].genre))))
        onView(withId(R.id.tv_movie_detail_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_release_date)).check((matches(withText(dummyMovies[0].releaseDate))))
        onView(withId(R.id.tv_movie_detail_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_runtime)).check((matches(withText(dummyMovies[0].duration))))
        onView(withId(R.id.tv_movie_detail_imdb_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_imdb_rating)).check((matches(withText(dummyMovies[0].imdbRating+"/10"))))
        onView(withId(R.id.tv_movie_detail_synopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_synopsis)).check((matches(withText(dummyMovies[0].plot))))
        onView(withId(R.id.tv_movie_detail_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_director)).check((matches(withText(dummyMovies[0].director))))
        onView(withId(R.id.tv_movie_detail_writer)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_writer)).check((matches(withText(dummyMovies[0].writer))))
        onView(withId(R.id.tv_movie_detail_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_detail_stars)).check((matches(withText(dummyMovies[0].actor))))
    }

    @Test
    fun loadTvShowDetail(){
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_tv_show_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_title)).check((matches(withText(dummyTvShows[0].title))))
        onView(withId(R.id.tv_tv_show_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_year)).check((matches(withText("(${dummyTvShows[0].year})"))))
        onView(withId(R.id.tv_tv_show_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_genre)).check((matches(withText(dummyTvShows[0].genre))))
        onView(withId(R.id.tv_tv_show_detail_episodes)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_episodes)).check((matches(withText(dummyTvShows[0].totalEpisodes.toString()+" Episodes"))))
        onView(withId(R.id.tv_tv_show_detail_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_runtime)).check((matches(withText(dummyTvShows[0].duration))))
        onView(withId(R.id.tv_tv_show_detail_imdb_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_imdb_rating)).check((matches(withText(dummyTvShows[0].imdbRating+"/10"))))
        onView(withId(R.id.tv_tv_show_detail_synopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_synopsis)).check((matches(withText(dummyTvShows[0].plot))))
        onView(withId(R.id.tv_tv_show_creator)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_creator)).check((matches(withText(dummyTvShows[0].creator))))
        onView(withId(R.id.tv_tv_show_detail_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_status)).check((matches(withText(dummyTvShows[0].status))))
        onView(withId(R.id.tv_tv_show_detail_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tv_show_detail_stars)).check((matches(withText(dummyTvShows[0].actor))))
    }

    @Test
    fun loadFavoriteMovies(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fab_fav_movie)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_favorite)).perform(click())
        onView(withId(R.id.rv_favorite_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoriteTvShows(){
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fab_fav_tv_show)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_favorite)).perform(click())
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_favorite_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(isRoot()).perform(ViewActions.pressBack())
    }

}