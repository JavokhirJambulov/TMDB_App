package uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource

import retrofit2.Response
import uz.javokhirjambulov.tmdbclient.data.model.movie.MovieList

interface MovieRemoteDatasource {
   suspend fun getMovies(): Response<MovieList>
}