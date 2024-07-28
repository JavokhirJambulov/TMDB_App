package uz.javokhirjambulov.tmdbclient.presentation.di.core


import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.domain.repository.ArtistsRepository
import uz.javokhirjambulov.tmdbclient.domain.repository.MovieRepository
import uz.javokhirjambulov.tmdbclient.domain.repository.TvShowRepository
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetArtistsUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetTvShowUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateArtistsUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateTvShowUseCase

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistsRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistsRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

}