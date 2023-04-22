package com.jhonjto.thecatapi.ui

import com.jhonjto.data.repository.CatListRepository
import com.jhonjto.usecases.GetCatList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {

    @Provides
    @ViewModelScoped
    fun getCatListProvider(catListRepository: CatListRepository) =
        GetCatList(catListRepository)
}