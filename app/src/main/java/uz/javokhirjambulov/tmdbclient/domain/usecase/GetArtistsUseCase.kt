package uz.javokhirjambulov.tmdbclient.domain.usecase

import uz.javokhirjambulov.tmdbclient.domain.repository.ArtistsRepository
import uz.javokhirjambulov.tmdbclient.data.model.artist.Artist

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute():List<Artist>? = artistsRepository.getArtists()
}