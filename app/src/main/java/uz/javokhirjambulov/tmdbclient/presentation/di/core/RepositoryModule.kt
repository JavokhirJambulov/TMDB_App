package uz.javokhirjambulov.tmdbclient.presentation.di.core


import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.MovieRepositoryImpl
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import uz.javokhirjambulov.tmdbclient.domain.repository.ArtistsRepository
import uz.javokhirjambulov.tmdbclient.domain.repository.MovieRepository
import uz.javokhirjambulov.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieCacheDataSource,
            movieLocalDataSource

        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowCacheDataSource,
            tvShowLocalDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistCacheDataSource,
            artistLocalDataSource,
        )


    }

}