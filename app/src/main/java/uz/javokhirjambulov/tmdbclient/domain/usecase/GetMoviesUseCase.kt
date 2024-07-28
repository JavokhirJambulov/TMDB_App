package uz.javokhirjambulov.tmdbclient.domain.usecase

import uz.javokhirjambulov.tmdbclient.domain.repository.MovieRepository
import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}