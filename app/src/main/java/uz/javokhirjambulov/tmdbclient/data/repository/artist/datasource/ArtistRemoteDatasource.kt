package uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource

import retrofit2.Response
import uz.javokhirjambulov.tmdbclient.data.model.artist.ArtistList

interface ArtistRemoteDatasource {
   suspend fun getArtist(): Response<ArtistList>
}