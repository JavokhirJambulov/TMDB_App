package uz.javokhirjambulov.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetTvShowUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
):ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowUseCase.execute()
        emit(tvShowList)
    }

}