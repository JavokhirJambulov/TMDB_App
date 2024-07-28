package uz.javokhirjambulov.tmdbclient.data.api

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uz.javokhirjambulov.tmdbclient.data.model.artist.ArtistList;
import uz.javokhirjambulov.tmdbclient.data.model.movie.MovieList;
import uz.javokhirjambulov.tmdbclient.data.model.tvshow.TvShowList;

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>
}