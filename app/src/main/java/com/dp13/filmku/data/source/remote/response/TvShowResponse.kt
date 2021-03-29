package com.dp13.filmku.data.source.remote.response

import android.os.Parcelable
import com.dp13.filmku.data.source.local.entity.FilmEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse (
        override var filmId: String,
        override var posterImg: String,
        override var title: String,
        override var year: String,
        override var genre: String,
        override var duration: String,
        override var imdbRating: String,
        override var plot: String,
        override var actor: String,
        var creator: String,
        var status: String,
        var totalEpisodes: Int
        ): Parcelable, FilmResponse()