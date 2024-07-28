package uz.javokhirjambulov.tmdbclient.presentation.di.artist


import dagger.Subcomponent
import uz.javokhirjambulov.tmdbclient.presentation.artist.ArtistActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }

}

