package uz.javokhirjambulov.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetArtistsUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateArtistsUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase,updateArtistsUseCase) as T
    }
}