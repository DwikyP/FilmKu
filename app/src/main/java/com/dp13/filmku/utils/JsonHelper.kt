package com.dp13.filmku.utils

import android.content.Context
import com.dp13.filmku.data.source.remote.response.MovieResponse
import com.dp13.filmku.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse>{
        val list = ArrayList<MovieResponse>()
        try{
            val responseObject = JSONObject(parsingFileToString("MoviesResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for(i in 0 until  listArray.length()){
                val movie = listArray.getJSONObject(i)

                val filmId = movie.getString("filmid")
                val posterImg = movie.getString("posterImg")
                val title = movie.getString("title")
                val year = movie.getString("year")
                val genre = movie.getString("genre")
                val duration = movie.getString("duration")
                val imdbRating = movie.getString("imdbRating")
                val plot = movie.getString("plot")
                val actor = movie.getString("actor")
                val director = movie.getString("director")
                val writer = movie.getString("writer")
                val releaseDate = movie.getString("releaseDate")

                val movieResponse = MovieResponse(filmId, posterImg, title, year, genre, duration, imdbRating, plot, actor, director, writer, releaseDate)
                list.add(movieResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShows(): List<TvShowResponse>{
        val list = ArrayList<TvShowResponse>()
        try{
            val responseObject = JSONObject(parsingFileToString("TvShowsResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for(i in 0 until  listArray.length()){
                val movie = listArray.getJSONObject(i)

                val filmId = movie.getString("filmid")
                val posterImg = movie.getString("posterImg")
                val title = movie.getString("title")
                val year = movie.getString("year")
                val genre = movie.getString("genre")
                val duration = movie.getString("duration")
                val imdbRating = movie.getString("imdbRating")
                val plot = movie.getString("plot")
                val actor = movie.getString("actor")
                val creater = movie.getString("creater")
                val status = movie.getString("status")
                val totalEpisodes = movie.getInt("totalEpisodes")

                val tvShowResponse = TvShowResponse(filmId, posterImg, title, year, genre, duration, imdbRating, plot, actor, creater, status, totalEpisodes)
                list.add(tvShowResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
        return list
    }

}