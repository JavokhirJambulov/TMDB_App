package uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.javokhirjambulov.tmdbclient.data.db.MovieDao
import uz.javokhirjambulov.tmdbclient.data.db.TvShowDao
import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShow
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao):
    TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
       return tvShowDao.getTvSHows()
    }

    override suspend fun saveTvShowsToDB(movies: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(movies)
        }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           tvShowDao.deleteAllTvShows()
       }
    }
}