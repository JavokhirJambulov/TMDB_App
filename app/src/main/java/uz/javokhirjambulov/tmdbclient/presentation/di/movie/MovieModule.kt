package uz.javokhirjambulov.tmdbclient.presentation.di.movie


import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.domain.usecase.GetMoviesUseCase
import uz.javokhirjambulov.tmdbclient.domain.usecase.UpdateMoviesUseCase
import uz.javokhirjambulov.tmdbclient.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}