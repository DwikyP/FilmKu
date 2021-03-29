package com.dp13.filmku.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dp13.filmku.R
import com.dp13.filmku.databinding.ItemMovieListBinding
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.ui.detail.MovieDetailActivity

class MoviesAdapter: PagedListAdapter<MovieEntity, MoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.filmId == newItem.filmId
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MoviesViewHolder {
        val itemMoviesBinding = ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)
        if(movie != null){
            holder.bind(movie)
        }
    }

    class MoviesViewHolder(private val binding: ItemMovieListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieEntity){
            with(binding){
                tvMovieTitle.text = movie.title
                tvMovieYear.text = movie.year
                tvMoviePlot.text = movie.plot
                Glide.with(itemView.context)
                        .load(movie.posterImg)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgMoviePoster)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, MovieDetailActivity::class.java)
                    intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie.filmId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}