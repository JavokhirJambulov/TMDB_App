package uz.javokhirjambulov.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetTvShowUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase,updateTvShowUseCase) as T
    }
}