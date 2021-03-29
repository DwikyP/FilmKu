package com.dp13.filmku.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
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

        @ColumnInfo(name = "director")
        var director: String,

        @ColumnInfo(name = "writer")
        var writer: String,

        @ColumnInfo(name = "releaseDate")
        var releaseDate: String
): FilmEntity()