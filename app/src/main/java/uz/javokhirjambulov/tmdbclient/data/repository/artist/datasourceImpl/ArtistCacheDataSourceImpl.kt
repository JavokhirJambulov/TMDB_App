package uz.javokhirjambulov.tmdbclient.data.repository.artist.datasourceImpl

import uz.javokhirjambulov.tmdbclient.data.model.artist.Artist
import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource


class ArtistCacheDataSourceImpl :
    ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }


}