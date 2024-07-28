package uz.javokhirjambulov.tmdbclient.data.repository.artist.datasourceImpl

import retrofit2.Response
import uz.javokhirjambulov.tmdbclient.data.api.TMDBService
import uz.javokhirjambulov.tmdbclient.data.model.artist.ArtistList
import uz.javokhirjambulov.tmdbclient.data.model.movie.MovieList
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDatasource {
    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}

