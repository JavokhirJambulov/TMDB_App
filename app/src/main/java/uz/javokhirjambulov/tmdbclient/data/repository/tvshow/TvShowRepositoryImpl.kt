package uz.javokhirjambulov.tmdbclient.data.repository.tvshow

import android.util.Log
import uz.javokhirjambulov.tmdbclient.data.model.movie.Movie
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShow
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import uz.javokhirjambulov.tmdbclient.domain.repository.MovieRepository
import uz.javokhirjambulov.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource
):TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows

    }

    suspend fun getTvShowsFromAPI(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }


        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return tvShowList

    }
    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList

    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }

        return tvShowList

    }
}