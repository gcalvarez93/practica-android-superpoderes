package com.gabrielcastro.practicaandroidsuperpoderes.data.mappers

import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroLocal
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.SuperHeroRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.MarvelResponseObject
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor() {

    fun mapList(marvelResponseObject: MarvelResponseObject): List<SuperHeroLocal> {
        return marvelResponseObject.data.results.map { mapList(it) }
    }

    private fun mapList (superHeroRemote: SuperHeroRemote): SuperHeroLocal {
        return SuperHeroLocal(
            id = superHeroRemote.id,
            name = superHeroRemote.name,
            photo = "${superHeroRemote.thumbnail.path}.${superHeroRemote.thumbnail.extension}",
            description = superHeroRemote.description,
            favorite = false
        )
    }
}