package com.jhonjto.data.repository

import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.domain.CatListItem

class CatListRepository(
    private val remoteDataSource: RemoteDataSource,
    private val apiKey: String
) {
    suspend fun getCatList(): List<CatListItem> {
        return remoteDataSource.getCatList(apiKey)
    }
}