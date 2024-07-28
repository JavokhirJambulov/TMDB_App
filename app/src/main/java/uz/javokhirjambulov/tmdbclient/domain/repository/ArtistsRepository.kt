package uz.javokhirjambulov.tmdbclient.domain.repository

import uz.javokhirjambulov.tmdbclient.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}