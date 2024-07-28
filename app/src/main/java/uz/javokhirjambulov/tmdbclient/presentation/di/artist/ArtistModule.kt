package uz.javokhirjambulov.tmdbclient.presentation.di.artist


import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetArtistsUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateArtistsUseCase
import uz.javokhirjambulov.tmdbclient.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}