package com.dp13.filmku.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritetvshows")
data class FavoriteTvShowEntity (
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "filmId")
    var filmId: String,

    @ColumnInfo(name = "posterImg")
    var posterImg: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "plot")
    var plot: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "totalEpisodes")
    var totalEpisodes: Int
        )