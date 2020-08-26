package com.example.code_hero.di

import com.example.code_hero.BaseInterceptor
import com.example.code_hero.data.HeroesService
import com.example.code_hero.domain.HeroesRepository
import com.example.code_hero.domain.HeroesRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    const val BASE_URL = "http://gateway.marvel.com/v1/public/"

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(BaseInterceptor())
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(BaseInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    fun provideHeroesService(retrofit: Retrofit) = retrofit.create(HeroesService::class.java)

    @Module
    @InstallIn(ApplicationComponent::class)
    abstract class RepositoryModule {

        @Binds
        abstract fun provideHeroesRepository(repositoryImpl: HeroesRepositoryImpl): HeroesRepository

    }

}


