package com.dp13.filmku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dp13.filmku.R
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.databinding.ActivityMovieDetailBinding
import com.dp13.filmku.databinding.ContentMovieDetailBinding
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.viewmodel.ViewModelFactory

class MovieDetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var activityMovieDetailBinding: ActivityMovieDetailBinding
    private lateinit var detailContentMovieBinding: ContentMovieDetailBinding

    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMovieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        detailContentMovieBinding = activityMovieDetailBinding.detailContent

        setContentView(activityMovieDetailBinding.root)

        setSupportActionBar(activityMovieDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lateinit var favoriteMovie: FavoriteMovieEntity

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[MovieDetailViewModel::class.java]

        val extras = intent.extras
        if(extras != null){
            val movieId = extras.getString(EXTRA_MOVIE)
            if(movieId != null){
                activityMovieDetailBinding.movieDetailProgressBar.visibility = View.VISIBLE
                activityMovieDetailBinding.content.visibility = View.INVISIBLE

                viewModel.setSelectedMovie(movieId)
                viewModel.getMovie().observe(this, {movie ->
                    activityMovieDetailBinding.movieDetailProgressBar.visibility = View.GONE
                    activityMovieDetailBinding.content.visibility = View.VISIBLE

                    favoriteMovie = FavoriteMovieEntity(
                        movie.filmId,
                        movie.posterImg,
                        movie.title,
                        movie.year,
                        movie.plot
                    )
                    populateMovieDetail(movie)
                })
            }
        }

        var statusFavorite = false
        viewModel.getFavoriteMovie().observe(this, {favMovie ->
            statusFavorite = favMovie != null
            setFavoriteMovie(statusFavorite)
        })

        activityMovieDetailBinding.fabFavMovie.setOnClickListener{
            statusFavorite = !statusFavorite
            if (statusFavorite){
                viewModel.insertFavoriteMovie(favoriteMovie)
            }
            else{
                viewModel.deleteFavoriteMovie(favoriteMovie)
            }
            setFavoriteMovie(statusFavorite)
        }
    }

    private fun populateMovieDetail(movieEntity: MovieEntity){
        detailContentMovieBinding.tvMovieDetailTitle.text = movieEntity.title
        detailContentMovieBinding.tvMovieDetailYear.text = "(${movieEntity.year})"
        detailContentMovieBinding.tvMovieDetailGenre.text = movieEntity.genre
        detailContentMovieBinding.tvMovieDetailReleaseDate.text = movieEntity.releaseDate
        detailContentMovieBinding.tvMovieDetailRuntime.text = movieEntity.duration
        detailContentMovieBinding.tvMovieDetailImdbRating.text = movieEntity.imdbRating + "/10"
        detailContentMovieBinding.tvMovieDetailSynopsis.text = movieEntity.plot
        detailContentMovieBinding.tvMovieDetailDirector.text = movieEntity.director
        detailContentMovieBinding.tvMovieDetailWriter.text = movieEntity.writer
        detailContentMovieBinding.tvMovieDetailStars.text = movieEntity.actor
        Glide.with(this)
            .load(movieEntity.posterImg)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(detailContentMovieBinding.imgPoster)
    }

    private fun setFavoriteMovie(status: Boolean){
        if(status)
            activityMovieDetailBinding.fabFavMovie.setImageResource(R.drawable.ic_favorite_true)
        else
            activityMovieDetailBinding.fabFavMovie.setImageResource(R.drawable.ic_favorite_false)
    }
}