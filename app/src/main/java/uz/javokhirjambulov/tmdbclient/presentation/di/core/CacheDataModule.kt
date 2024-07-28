package uz.javokhirjambulov.tmdbclient.presentation.di.core


import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import uz.javokhirjambulov.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}