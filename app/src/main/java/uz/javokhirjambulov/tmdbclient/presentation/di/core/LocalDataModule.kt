package uz.javokhirjambulov.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.data.db.ArtistDao
import uz.javokhirjambulov.tmdbclient.data.db.MovieDao
import uz.javokhirjambulov.tmdbclient.data.db.TvShowDao
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }


}