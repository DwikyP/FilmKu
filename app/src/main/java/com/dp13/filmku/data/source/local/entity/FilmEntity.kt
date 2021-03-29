package com.dp13.filmku.data.source.local.entity

abstract class FilmEntity {
    abstract var filmId: String
    abstract var posterImg: String
    abstract var title: String
    abstract var year: String
    abstract var genre: String
    abstract var duration: String
    abstract var imdbRating: String
    abstract var plot: String
    abstract var actor: String
}