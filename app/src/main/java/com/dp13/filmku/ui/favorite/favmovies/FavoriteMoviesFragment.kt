package com.dp13.filmku.ui.favorite.favmovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dp13.filmku.R
import com.dp13.filmku.adapter.FavoriteMoviesAdapter
import com.dp13.filmku.databinding.FragmentFavoriteMoviesBinding
import com.dp13.filmku.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment() {
    private lateinit var favoriteMoviesViewBinding: FragmentFavoriteMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        favoriteMoviesViewBinding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return favoriteMoviesViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteMoviesViewModel::class.java]

            val favoriteMoviesAdapter = FavoriteMoviesAdapter()

            favoriteMoviesViewBinding.favoriteMoviesProgressBar.visibility = View.VISIBLE
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, {favoriteMovies ->
                favoriteMoviesViewBinding.favoriteMoviesProgressBar.visibility = View.GONE
                favoriteMoviesAdapter.submitList(favoriteMovies)
            })
            with(favoriteMoviesViewBinding.rvFavoriteMovies){
                layoutManager = LinearLayoutManager(context)
                adapter = favoriteMoviesAdapter
            }
        }
    }
}