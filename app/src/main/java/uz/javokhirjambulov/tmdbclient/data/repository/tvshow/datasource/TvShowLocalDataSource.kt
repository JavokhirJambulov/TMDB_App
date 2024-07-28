package uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource

import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
  suspend fun getTvShowsFromDB():List<TvShow>
  suspend fun saveTvShowsToDB(movies:List<TvShow>)
  suspend fun clearAll()
}