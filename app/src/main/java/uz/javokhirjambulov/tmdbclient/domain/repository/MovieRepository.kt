package uz.javokhirjambulov.tmdbclient.domain.repository

import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}