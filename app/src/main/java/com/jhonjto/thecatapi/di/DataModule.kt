package com.jhonjto.thecatapi.di

import com.jhonjto.data.repository.CatListRepository
import com.jhonjto.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun catListRepositoryProvider(
        remoteDataSource: RemoteDataSource,
        @Named("apiKey") apiKey: String
    ) = CatListRepository(remoteDataSource, apiKey)
}