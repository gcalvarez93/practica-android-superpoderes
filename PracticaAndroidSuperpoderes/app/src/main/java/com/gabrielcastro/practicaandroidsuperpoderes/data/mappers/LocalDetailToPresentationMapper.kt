package com.gabrielcastro.practicaandroidsuperpoderes.data.mappers

import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroDetailLocal
import com.gabrielcastro.practicaandroidsuperpoderes.domain.SuperHeroDetail
import javax.inject.Inject

class LocalDetailToPresentationMapper @Inject constructor() {

    fun map(superHeroDetailLocal: SuperHeroDetailLocal): SuperHeroDetail {
        return SuperHeroDetail(
            id = superHeroDetailLocal.id,
            name = superHeroDetailLocal.name,
            photo = superHeroDetailLocal.photo,
            description = superHeroDetailLocal.description,
            favorite = superHeroDetailLocal.favorite
        )
    }
}