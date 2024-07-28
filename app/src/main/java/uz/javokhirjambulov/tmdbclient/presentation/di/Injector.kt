package uz.javokhirjambulov.tmdbclient.presentation.di


import uz.javokhirjambulov.tmdbclient.presentation.di.artist.ArtistSubComponent
import uz.javokhirjambulov.tmdbclient.presentation.di.movie.MovieSubComponent
import uz.javokhirjambulov.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}