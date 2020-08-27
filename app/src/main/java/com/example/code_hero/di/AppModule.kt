package com.example.code_hero.di

import com.example.code_hero.data.service.HeroesService
import com.example.code_hero.data.repository.HeroesRepository
import com.example.code_hero.data.repository.HeroesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideBaseUrl() = BASE_URL

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideHeroesService(retrofit: Retrofit) = retrofit.create(HeroesService::class.java)

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

}

@Module
@InstallIn(ApplicationComponent::class)
object HeroesModule {
    @Singleton
    @Provides
    fun provideHeroesRepository(service: HeroesService, ioDispatcher: CoroutineDispatcher): HeroesRepository {
        return HeroesRepositoryImpl(service, ioDispatcher)
    }
}
