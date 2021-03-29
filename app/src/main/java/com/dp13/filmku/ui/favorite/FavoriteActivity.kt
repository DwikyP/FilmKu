package com.dp13.filmku.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.dp13.filmku.R
import com.dp13.filmku.databinding.ActivityFavoriteBinding
import com.dp13.filmku.ui.home.SectionsPagerAdapter

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        val favSectionsPagerAdapter = FavoriteSectionsPagerAdapter(this, supportFragmentManager)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        activityFavoriteBinding.viewPagerFav.adapter = favSectionsPagerAdapter
        activityFavoriteBinding.tabsFav.setupWithViewPager(activityFavoriteBinding.viewPagerFav)
        supportActionBar?.elevation = 0f
    }
}