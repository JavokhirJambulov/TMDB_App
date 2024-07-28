package uz.javokhirjambulov.tmdbclient.presentation.di.tvshow


import dagger.Subcomponent
import uz.javokhirjambulov.tmdbclient.presentation.tv.TvShowActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }

}

