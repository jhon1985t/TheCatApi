package com.jhonjto.data.source

import com.jhonjto.domain.CatListItem

interface RemoteDataSource {
    suspend fun getCatList(apikey: String): List<CatListItem>
}