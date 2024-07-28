package uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasourceImpl

import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShow
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource


class TvShowCacheDataSourceImpl :
    TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(movies: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(movies)
    }
}