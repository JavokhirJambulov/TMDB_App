package uz.javokhirjambulov.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetArtistsUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateArtistsUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }

}