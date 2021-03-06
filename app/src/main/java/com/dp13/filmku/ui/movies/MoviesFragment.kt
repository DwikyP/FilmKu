package com.dp13.filmku.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dp13.filmku.adapter.MoviesAdapter
import com.dp13.filmku.databinding.FragmentMoviesBinding
import com.dp13.filmku.viewmodel.ViewModelFactory
import com.dp13.filmku.vo.Status

class MoviesFragment : Fragment() {
    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val moviesAdapter = MoviesAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, {movies ->
                if(movies != null){
                    when(movies.status){
                        Status.LOADING -> fragmentMoviesBinding.moviesProgressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMoviesBinding.moviesProgressBar.visibility = View.GONE
                            moviesAdapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
                            fragmentMoviesBinding.moviesProgressBar.visibility = View.GONE
                            Toast.makeText(context, "Error Loading", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })

            with(fragmentMoviesBinding.rvMovies){
                layoutManager = LinearLayoutManager(context)
                adapter = moviesAdapter
            }
        }
    }
}