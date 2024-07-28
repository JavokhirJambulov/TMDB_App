package uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource

import uz.javokhirjambulov.tmdbclient.data.model.artist.Artist
import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie

interface ArtistLocalDataSource {
  suspend fun getArtistFromDB():List<Artist>
  suspend fun saveArtistToDB(artist:List<Artist>)
  suspend fun clearAll()
}