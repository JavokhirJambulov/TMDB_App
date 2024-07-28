package uz.javokhirjambulov.tmdbclient.domain.repository

import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}