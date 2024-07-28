package uz.javokhirjambulov.tmdbclient.presentation.di.movie


import dagger.Subcomponent
import uz.javokhirjambulov.tmdbclient.presentation.di.movie.MovieModule
import uz.javokhirjambulov.tmdbclient.presentation.di.movie.MovieScope
import uz.javokhirjambulov.tmdbclient.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }

}

