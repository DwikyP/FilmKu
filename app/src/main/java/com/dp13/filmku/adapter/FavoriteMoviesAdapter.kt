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
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.databinding.ItemMovieListBinding
import com.dp13.filmku.ui.detail.MovieDetailActivity

class FavoriteMoviesAdapter: PagedListAdapter<FavoriteMovieEntity, FavoriteMoviesAdapter.FavoriteMoviesViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FavoriteMovieEntity>() {
            override fun areItemsTheSame(oldItem: FavoriteMovieEntity, newItem: FavoriteMovieEntity): Boolean {
                return oldItem.filmId == newItem.filmId
            }
            override fun areContentsTheSame(oldItem: FavoriteMovieEntity, newItem: FavoriteMovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteMoviesViewHolder {
        val itemMoviesBinding = ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMoviesViewHolder(itemMoviesBinding)
    }

    override fun onBindViewHolder(
        holder: FavoriteMoviesViewHolder,
        position: Int
    ) {
        val favoriteMovie = getItem(position)
        if (favoriteMovie != null) {
            holder.bind(favoriteMovie)
        }
    }


    class FavoriteMoviesViewHolder(private val binding: ItemMovieListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteMovie: FavoriteMovieEntity){
            with(binding){
                tvMovieTitle.text = favoriteMovie.title
                tvMovieYear.text = favoriteMovie.year
                tvMoviePlot.text = favoriteMovie.plot
                Glide.with(itemView.context)
                    .load(favoriteMovie.posterImg)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgMoviePoster)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, MovieDetailActivity::class.java)
                    intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, favoriteMovie.filmId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}