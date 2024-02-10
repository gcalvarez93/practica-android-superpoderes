package com.gabrielcastro.practicaandroidsuperpoderes.data.mappers

import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroDetailLocal
import com.gabrielcastro.practicaandroidsuperpoderes.domain.SuperHero
import com.gabrielcastro.practicaandroidsuperpoderes.domain.SuperHeroDetail
import javax.inject.Inject
// SuperHero → SuperHeroDetailLocal
class PresentationToLocalMapper @Inject constructor() {

    fun map(superHeroList: List<SuperHeroDetail>): List<SuperHeroDetailLocal> {
        return superHeroList.map { map(it) }
    }

    fun map(superHeroDetail: SuperHeroDetail): SuperHeroDetailLocal {
        return SuperHeroDetailLocal(
            id = superHeroDetail.id,
            name = superHeroDetail.name,
            description = superHeroDetail.description,
            photo = superHeroDetail.photo,
            favorite = superHeroDetail.favorite
        )
    }
    fun map2(superHero: SuperHero): SuperHeroDetailLocal {
        return SuperHeroDetailLocal(
            id = superHero.id,
            name = superHero.name,
            description = superHero.description,
            photo = superHero.photo,
            favorite = superHero.favorite
        )
    }
}