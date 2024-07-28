package uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource

import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)

}