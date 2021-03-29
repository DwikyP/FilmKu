package com.dp13.filmku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dp13.filmku.R
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.databinding.ActivityTvShowDetailBinding
import com.dp13.filmku.databinding.ContentTvShowDetailBinding
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.viewmodel.ViewModelFactory

class TvShowDetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var activityTvShowDetailBinding: ActivityTvShowDetailBinding
    private lateinit var detailContentTvShowsBinding: ContentTvShowDetailBinding

    private lateinit var viewModel: TvShowDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTvShowDetailBinding = ActivityTvShowDetailBinding.inflate(layoutInflater)
        detailContentTvShowsBinding = activityTvShowDetailBinding.detailContent

        setContentView(activityTvShowDetailBinding.root)

        setSupportActionBar(activityTvShowDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lateinit var favoriteTvShow: FavoriteTvShowEntity

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[TvShowDetailViewModel::class.java]

        val extras = intent.extras
        if(extras != null){
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                activityTvShowDetailBinding.tvShowDetailProgressBar.visibility = View.VISIBLE
                activityTvShowDetailBinding.content.visibility = View.INVISIBLE

                viewModel.setSelectedTvShow(tvShowId)
                viewModel.getTvShow().observe(this, { tvShow ->
                    activityTvShowDetailBinding.tvShowDetailProgressBar.visibility = View.GONE
                    activityTvShowDetailBinding.content.visibility = View.VISIBLE

                    favoriteTvShow = FavoriteTvShowEntity(
                        tvShow.filmId,
                        tvShow.posterImg,
                        tvShow.title,
                        tvShow.year,
                        tvShow.plot,
                        tvShow.status,
                        tvShow.totalEpisodes
                    )
                    populateTvShow(tvShow)
                })
            }
        }
        var statusFavorite = false
        viewModel.getFavoriteTvShow().observe(this, {favTvShow ->
            statusFavorite = favTvShow != null
            setFavoriteTvShow(statusFavorite)
        })

        activityTvShowDetailBinding.fabFavTvShow.setOnClickListener {
            statusFavorite = !statusFavorite
            if (statusFavorite){
                viewModel.insertFavoriteTvShow(favoriteTvShow)
            }
            else{
                viewModel.deleteFavoriteTvShow(favoriteTvShow)
            }
            setFavoriteTvShow(statusFavorite)
        }
    }

    fun populateTvShow(tvShow: TvShowEntity){
        detailContentTvShowsBinding.tvTvShowDetailTitle.text = tvShow.title
        detailContentTvShowsBinding.tvTvShowDetailYear.text = "(${tvShow.year})"
        detailContentTvShowsBinding.tvTvShowDetailGenre.text = tvShow.genre
        detailContentTvShowsBinding.tvTvShowDetailEpisodes.text = tvShow.totalEpisodes.toString() + " Episodes"
        detailContentTvShowsBinding.tvTvShowDetailRuntime.text = tvShow.duration
        detailContentTvShowsBinding.tvTvShowDetailImdbRating.text = tvShow.imdbRating + "/10"
        detailContentTvShowsBinding.tvTvShowDetailSynopsis.text = tvShow.plot
        detailContentTvShowsBinding.tvTvShowCreator.text = tvShow.creator
        detailContentTvShowsBinding.tvTvShowDetailStatus.text = tvShow.status
        detailContentTvShowsBinding.tvTvShowDetailStars.text = tvShow.actor
        Glide.with(this)
                .load(tvShow.posterImg)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_error)
                .into(detailContentTvShowsBinding.imgPoster)
    }

    private fun setFavoriteTvShow(status: Boolean){
        if(status)
            activityTvShowDetailBinding.fabFavTvShow.setImageResource(R.drawable.ic_favorite_true)
        else
            activityTvShowDetailBinding.fabFavTvShow.setImageResource(R.drawable.ic_favorite_false)
    }
}