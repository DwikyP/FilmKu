package com.dp13.filmku.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dp13.filmku.data.source.local.LocalDataSource
import com.dp13.filmku.data.source.local.entity.FavoriteMovieEntity
import com.dp13.filmku.data.source.local.entity.FavoriteTvShowEntity
import com.dp13.filmku.data.source.local.entity.MovieEntity
import com.dp13.filmku.data.source.local.entity.TvShowEntity
import com.dp13.filmku.data.source.remote.ApiResponse
import com.dp13.filmku.data.source.remote.RemoteDataSource
import com.dp13.filmku.data.source.remote.response.MovieResponse
import com.dp13.filmku.data.source.remote.response.TvShowResponse
import com.dp13.filmku.utils.AppExecutors
import com.dp13.filmku.vo.Resource

class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors):
    FilmDataSource {
    companion object {
        @Volatile
        private var instance: FilmRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): FilmRepository =
                instance ?: synchronized(this) {
                    instance ?: FilmRepository(remoteData, localData, appExecutors)
                }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object: NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors){
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>>{
                    val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(5)
                        .setPageSize(5)
                        .build()
                    return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
                }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val movie = MovieEntity(
                        response.filmId,
                        response.posterImg,
                        response.title,
                        response.year,
                        response.genre,
                        response.duration,
                        response.imdbRating,
                        response.plot,
                        response.actor,
                        response.director,
                        response.writer,
                        response.releaseDate
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object: NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors){
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(tvShowResponses: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponses) {
                    val tvShow = TvShowEntity(response.filmId,
                        response.posterImg,
                        response.title,
                        response.year,
                        response.genre,
                        response.duration,
                        response.imdbRating,
                        response.plot,
                        response.actor,
                        response.creator,
                        response.status,
                        response.totalEpisodes)
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<FavoriteMovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<FavoriteTvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun getMovie(filmId: String): LiveData<MovieEntity> = localDataSource.getMovie(filmId)

    override fun getTvShow(filmId: String): LiveData<TvShowEntity> = localDataSource.getTvShow(filmId)

    override fun getFavoriteMovie(filmId: String): LiveData<FavoriteMovieEntity> = localDataSource.getFavoriteMovie(filmId)

    override fun getFavoriteTvShow(filmId: String): LiveData<FavoriteTvShowEntity> = localDataSource.getFavoriteTvShow(filmId)

    override fun insertFavoriteMovie(favoriteMovie: FavoriteMovieEntity) {
        appExecutors.diskIO().execute{localDataSource.insertFavoriteMovie(favoriteMovie)}
    }

    override fun deleteFavoriteMovie(favoriteMovie: FavoriteMovieEntity) {
        appExecutors.diskIO().execute{localDataSource.deleteFavoriteMovie(favoriteMovie)}
    }

    override fun insertFavoriteTvShow(favoriteTvShow: FavoriteTvShowEntity) {
        appExecutors.diskIO().execute{localDataSource.insertFavoriteTvShow(favoriteTvShow)}
    }

    override fun deleteFavoriteTvShow(favoriteTvShow: FavoriteTvShowEntity) {
        appExecutors.diskIO().execute{localDataSource.deleteFavoriteTvShow(favoriteTvShow)}
    }
}