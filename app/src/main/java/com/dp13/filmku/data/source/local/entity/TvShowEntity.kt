package com.dp13.filmku.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshows")
data class TvShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "filmId")
        override var filmId: String,

        @ColumnInfo(name = "posterImg")
        override var posterImg: String,

        @ColumnInfo(name = "title")
        override var title: String,

        @ColumnInfo(name = "year")
        override var year: String,

        @ColumnInfo(name = "genre")
        override var genre: String,

        @ColumnInfo(name = "duration")
        override var duration: String,

        @ColumnInfo(name = "imdbRating")
        override var imdbRating: String,

        @ColumnInfo(name = "plot")
        override var plot: String,

        @ColumnInfo(name = "actor")
        override var actor: String,

        @ColumnInfo(name = "creator")
        var creator: String,

        @ColumnInfo(name = "status")
        var status: String,

        @ColumnInfo(name = "totalEpisodes")
        var totalEpisodes: Int
): FilmEntity()