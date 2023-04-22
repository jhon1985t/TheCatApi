package com.jhonjto.thecatapi.server.mappers

import com.jhonjto.domain.CatListItem
import com.jhonjto.domain.Weight
import com.jhonjto.thecatapi.server.response.CatsListResponseItem

fun CatsListResponseItem.toDomainCatListItem(): CatListItem {

    val weightResult = Weight(
        weight.imperial,
        weight.metric
    )

    return CatListItem(
        adaptability,
        affection_level,
        alt_names,
        bidability,
        cat_friendly,
        cfa_url,
        child_friendly,
        chirp,
        country_code,
        country_codes,
        description,
        dog_friendly,
        energy_level,
        experimental,
        grooming,
        hairless,
        health_issues,
        hypoallergenic,
        id,
        indoor,
        intelligence,
        lap,
        life_span,
        name,
        natural,
        origin,
        rare,
        reference_image_id,
        rex,
        shedding_level,
        short_legs,
        social_needs,
        stranger_friendly,
        suppressed_tail,
        talk,
        temperament,
        vcahospitals_url,
        vetstreet_url,
        vocalisation,
        weightResult,
        wikipedia_url
    )
}