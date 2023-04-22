package com.jhonjto.thecatapi.di

import android.app.Application
import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.thecatapi.R
import com.jhonjto.thecatapi.server.TheCatApiDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app: Application): String = app.getString(R.string.api_key)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = TheCatApiDataSource()
}