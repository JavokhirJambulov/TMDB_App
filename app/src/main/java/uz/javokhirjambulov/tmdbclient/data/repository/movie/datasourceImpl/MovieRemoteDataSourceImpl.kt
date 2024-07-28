package uz.javokhirjambulov.tmdbclient.data.repository.movie.datasourceImpl

import retrofit2.Response
import uz.javokhirjambulov.tmdbclient.data.api.TMDBService
import uz.javokhirjambulov.tmdbclient.data.model.movie.MovieList
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}

