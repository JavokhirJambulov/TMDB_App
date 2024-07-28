package uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasourceImpl

import retrofit2.Response
import uz.javokhirjambulov.tmdbclient.data.api.TMDBService
import uz.javokhirjambulov.tmdbclient.data.model.movie.MovieList
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShowList
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}

