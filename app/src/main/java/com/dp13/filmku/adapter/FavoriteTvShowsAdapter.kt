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
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.databinding.ItemTvShowListBinding
import com.dp13.filmku.ui.detail.TvShowDetailActivity

class FavoriteTvShowsAdapter: PagedListAdapter<FavoriteTvShowEntity, FavoriteTvShowsAdapter.FavoriteTvShowsViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FavoriteTvShowEntity>() {
            override fun areItemsTheSame(oldItem: FavoriteTvShowEntity, newItem: FavoriteTvShowEntity): Boolean {
                return oldItem.filmId == newItem.filmId
            }
            override fun areContentsTheSame(oldItem: FavoriteTvShowEntity, newItem: FavoriteTvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteTvShowsViewHolder {
        val itemTvShowsBinding = ItemTvShowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvShowsViewHolder(itemTvShowsBinding)
    }

    override fun onBindViewHolder(
        holder: FavoriteTvShowsViewHolder,
        position: Int
    ) {
        val favoriteTvShow = getItem(position)
        if (favoriteTvShow != null) {
            holder.bind(favoriteTvShow)
        }
    }

    class FavoriteTvShowsViewHolder(private val binding: ItemTvShowListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteTvShow: FavoriteTvShowEntity){
            with(binding){
                tvTvShowTitle.text = favoriteTvShow.title
                tvTvShowYear.text = favoriteTvShow.year
                tvTvShowPlot.text = favoriteTvShow.plot
                tvTvShowStatus.text = favoriteTvShow.status
                if(favoriteTvShow.status == "COMPLETED")
                    tvTvShowStatus.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))
                tvTvShowEpisodes.text = "${favoriteTvShow.totalEpisodes.toString()} Episodes"
                Glide.with(itemView.context)
                    .load(favoriteTvShow.posterImg)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgTvShowPoster)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, TvShowDetailActivity::class.java)
                    intent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, favoriteTvShow.filmId)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }


}