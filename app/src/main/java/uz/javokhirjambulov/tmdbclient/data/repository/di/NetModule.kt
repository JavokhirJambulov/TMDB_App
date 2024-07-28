package uz.javokhirjambulov.tmdbclient.data.repository.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.javokhirjambulov.tmdbclient.data.api.TMDBService
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }

}
