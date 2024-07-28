package uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource

import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
  suspend fun getMoviesFromDB():List<Movie>
  suspend fun saveMoviesToDB(movies:List<Movie>)
  suspend fun clearAll()
}