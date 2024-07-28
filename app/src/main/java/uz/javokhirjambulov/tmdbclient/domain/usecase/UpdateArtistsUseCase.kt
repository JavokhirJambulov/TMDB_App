package uz.javokhirjambulov.tmdbclient.domain.usecase

import uz.javokhirjambulov.tmdbclient.domain.repository.ArtistsRepository
import uz.javokhirjambulov.tmdbclient.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute():List<Artist>? = artistsRepository.updateArtists()
}