package com.dp13.filmku.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dp13.filmku.adapter.TvShowsAdapter
import com.dp13.filmku.databinding.FragmentTvShowsBinding
import com.dp13.filmku.viewmodel.ViewModelFactory
import com.dp13.filmku.vo.Status

class TvShowsFragment : Fragment() {
    private lateinit var fragmentTvShowsBinding: FragmentTvShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]

            val tvShowsAdapter = TvShowsAdapter()
            viewModel.getTvShows().observe(viewLifecycleOwner, {tvShows ->
                if(tvShows != null){
                    when(tvShows.status){
                        Status.LOADING -> fragmentTvShowsBinding.tvShowProgressBar.visibility = View.VISIBLE
                        Status.SUCCESS ->{
                            fragmentTvShowsBinding.tvShowProgressBar.visibility = View.GONE
                            tvShowsAdapter.submitList(tvShows.data)
                        }
                        Status.ERROR -> {
                            fragmentTvShowsBinding.tvShowProgressBar.visibility = View.GONE
                            Toast.makeText(context, "Error Loading", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })

            with(fragmentTvShowsBinding.rvTvShows){
                layoutManager = LinearLayoutManager(context)
                adapter = tvShowsAdapter
            }
        }
    }
}