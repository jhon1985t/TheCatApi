package com.jhonjto.usecases

import com.jhonjto.data.repository.CatListRepository
import com.jhonjto.domain.CatListItem

class GetCatList(private val catListRepository: CatListRepository) {
    suspend fun invoke(): List<CatListItem> = catListRepository.getCatList()
}