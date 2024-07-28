package uz.javokhirjambulov.tmdbclient.presentation.di.tvshow


import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetTvShowUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateTvShowUseCase
import uz.javokhirjambulov.tmdbclient.presentation.tv.TvShowViewModelFactory

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowUseCase,
        updateTvShowsUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}