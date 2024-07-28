package uz.javokhirjambulov.tmdbclient.data.repository.movie.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.javokhirjambulov.tmdbclient.data.db.MovieDao
import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource

class MovieLocalDataSourceImpl(private val movieDao: MovieDao):
    MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           movieDao.deleteAllMovies()
       }
    }
}