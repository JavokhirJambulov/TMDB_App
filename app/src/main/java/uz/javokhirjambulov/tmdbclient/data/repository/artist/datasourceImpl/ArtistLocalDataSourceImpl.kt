package uz.javokhirjambulov.tmdbclient.data.repository.artist.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.javokhirjambulov.tmdbclient.data.db.ArtistDao
import uz.javokhirjambulov.tmdbclient.data.model.artist.Artist
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao):
    ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
       return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           artistDao.deleteAllArtists()
       }
    }
}