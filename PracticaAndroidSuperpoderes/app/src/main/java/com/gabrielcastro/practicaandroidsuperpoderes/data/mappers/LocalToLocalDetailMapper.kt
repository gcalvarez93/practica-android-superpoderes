package com.gabrielcastro.practicaandroidsuperpoderes.data.mappers

import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroDetailLocal
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroLocal
import javax.inject.Inject

// SuperHeroLocal(s) → SuperHeroDetailLocal(s)
class LocalToLocalDetailMapper @Inject constructor() {

    fun map(superHeroLocalList: List<SuperHeroLocal>): List<SuperHeroDetailLocal> {
        return superHeroLocalList.map { map(it) }
    }

    fun map(superHeroLocal: SuperHeroLocal): SuperHeroDetailLocal {
        return SuperHeroDetailLocal(
            id = superHeroLocal.id,
            name = superHeroLocal.name,
            photo = superHeroLocal.photo,
            description = superHeroLocal.description,
            favorite = superHeroLocal.favorite
        )
    }
}