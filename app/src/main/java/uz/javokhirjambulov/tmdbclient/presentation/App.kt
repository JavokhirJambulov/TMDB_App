package uz.javokhirjambulov.tmdbclient.presentation

import android.app.Application
import uz.javokhirjambulov.tmdbclient.BuildConfig
import uz.javokhirjambulov.tmdbclient.presentation.di.Injector
import uz.javokhirjambulov.tmdbclient.presentation.di.artist.ArtistSubComponent
import uz.javokhirjambulov.tmdbclient.presentation.di.core.AppComponent
import uz.javokhirjambulov.tmdbclient.presentation.di.core.AppModule
import uz.javokhirjambulov.tmdbclient.presentation.di.core.DaggerAppComponent
import uz.javokhirjambulov.tmdbclient.presentation.di.core.NetModule
import uz.javokhirjambulov.tmdbclient.presentation.di.core.RemoteDataModule
import uz.javokhirjambulov.tmdbclient.presentation.di.movie.MovieSubComponent
import uz.javokhirjambulov.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Inject

class App : Application(), Injector {
private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
       return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}