package uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource

import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(movies:List<TvShow>)

}