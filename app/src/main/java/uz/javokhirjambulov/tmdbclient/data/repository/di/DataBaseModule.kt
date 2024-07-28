package uz.javokhirjambulov.tmdbclient.data.repository.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import uz.javokhirjambulov.tmdbclient.data.api.TMDBService
import uz.javokhirjambulov.tmdbclient.data.db.TMDBDatabase
import javax.inject.Singleton


@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java, "tmdbclient").build()
    }

}