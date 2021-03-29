package com.dp13.filmku.ui.favorite.favtvshows

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dp13.filmku.R
import com.dp13.filmku.adapter.FavoriteTvShowsAdapter
import com.dp13.filmku.databinding.FragmentFavoriteTvShowsBinding
import com.dp13.filmku.viewmodel.ViewModelFactory


class FavoriteTvShowsFragment : Fragment() {
    private lateinit var favoriteTvShowsViewBinding: FragmentFavoriteTvShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        favoriteTvShowsViewBinding = FragmentFavoriteTvShowsBinding.inflate(layoutInflater, container, false)
        return favoriteTvShowsViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, factory)[FavoriteTvShowsViewModel::class.java]

            val favoriteTvShowsAdapter = FavoriteTvShowsAdapter()

            favoriteTvShowsViewBinding.favoriteTvShowProgressBar.visibility = View.VISIBLE
            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, {favoriteTvShows ->
                favoriteTvShowsViewBinding.favoriteTvShowProgressBar.visibility = View.GONE
                favoriteTvShowsAdapter.submitList(favoriteTvShows)
            })
            with(favoriteTvShowsViewBinding.rvFavoriteTvShows){
                layoutManager = LinearLayoutManager(context)
                adapter = favoriteTvShowsAdapter
            }
        }
    }

}