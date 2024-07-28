package uz.javokhirjambulov.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.data.api.TMDBService
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }


}