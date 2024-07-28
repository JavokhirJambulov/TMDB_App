package uz.javokhirjambulov.tmdbclient.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.presentation.di.artist.ArtistSubComponent
import uz.javokhirjambulov.tmdbclient.presentation.di.movie.MovieSubComponent
import uz.javokhirjambulov.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }





}