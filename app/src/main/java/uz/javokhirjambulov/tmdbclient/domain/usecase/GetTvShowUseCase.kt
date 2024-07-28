package uz.javokhirjambulov.tmdbclient.domain.usecase

import uz.javokhirjambulov.tmdbclient.domain.repository.TvShowRepository
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShow

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? =  tvShowRepository.getTvShows()
}