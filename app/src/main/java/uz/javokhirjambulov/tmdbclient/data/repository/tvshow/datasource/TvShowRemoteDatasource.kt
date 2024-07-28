package uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource

import retrofit2.Response
import uz.javokhirjambulov.tmdbclient.data.model.movie.MovieList
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShowList

interface TvShowRemoteDatasource {
   suspend fun getTvShows(): Response<TvShowList>
}