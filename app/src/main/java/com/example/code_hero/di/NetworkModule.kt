package com.example.code_hero.di

import com.example.code_hero.BaseInterceptor
import com.example.code_hero.data.HeroesService
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
    const val PUBLIC_KEY = "9a84b6889039db500c250b40e104b070"
    const val HASH = "825389ab214ff3ae12d22e49dbe953c2"


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
    fun provideHeroesService() = retrofit.create(HeroesService::class.java)
    
}
