package uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource

import uz.javokhirjambulov.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artist:List<Artist>)

}