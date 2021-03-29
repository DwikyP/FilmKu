package com.dp13.filmku.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dp13.filmku.R
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.databinding.ItemTvShowListBinding
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.ui.detail.TvShowDetailActivity

class TvShowsAdapter: PagedListAdapter<TvShowEntity, TvShowsAdapter.TvShowsViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.filmId == newItem.filmId
            }
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val itemTvShowBinding = ItemTvShowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    class TvShowsViewHolder(private val binding: ItemTvShowListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity){
            with(binding){
                tvTvShowTitle.text = tvShow.title
                tvTvShowYear.text = tvShow.year
                tvTvShowPlot.text = tvShow.plot
                tvTvShowStatus.text = tvShow.status
                if(tvShow.status == "COMPLETED")
                    tvTvShowStatus.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))
                tvTvShowEpisodes.text = "${tvShow.totalEpisodes.toString()} Episodes"
                Glide.with(itemView.context)
                        .load(tvShow.posterImg)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgTvShowPoster)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, TvShowDetailActivity::class.java)
                    intent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShow.filmId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}