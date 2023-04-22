package com.jhonjto.thecatapi.server

import com.jhonjto.data.source.RemoteDataSource
import com.jhonjto.domain.CatListItem
import com.jhonjto.thecatapi.server.mappers.toDomainCatListItem

class TheCatApiDataSource : RemoteDataSource {
    override suspend fun getCatList(apikey: String): List<CatListItem> =
        TheCatApi.service
            .getListCats(apikey)
            .map {
                it.toDomainCatListItem()
            }
}