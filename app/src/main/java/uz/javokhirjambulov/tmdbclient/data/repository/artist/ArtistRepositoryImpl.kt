package uz.javokhirjambulov.tmdbclient.data.repository.artist

import android.util.Log
import uz.javokhirjambulov.tmdbclient.data.model.artist.Artist
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import uz.javokhirjambulov.tmdbclient.domain.repository.ArtistsRepository

class ArtistRepositoryImpl(
private val artistRemoteDatasource: ArtistRemoteDatasource,
private val artistCacheDataSource: ArtistCacheDataSource,
private val artistLocalDataSource: ArtistLocalDataSource
):ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists

    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response = artistRemoteDatasource.getArtist()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }


        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return artistList

    }
    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }

        return artistList

    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList

    }
}