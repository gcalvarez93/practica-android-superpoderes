package com.gabrielcastro.practicaandroidsuperpoderes.data.mappers

import com.gabrielcastro.practicaandroidsuperpoderes.SeriesRemote
import com.gabrielcastro.practicaandroidsuperpoderes.SeriesResult
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.ComicsRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.ComicsResult
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.SuperHeroRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.MarvelResponseObject
import com.gabrielcastro.practicaandroidsuperpoderes.domain.ComicsPresent
import com.gabrielcastro.practicaandroidsuperpoderes.domain.SeriesPresent
import com.gabrielcastro.practicaandroidsuperpoderes.domain.SuperHero
import javax.inject.Inject

class RemoteToPresentationMapper @Inject constructor() {

    fun mapList(marvelResponseObject: MarvelResponseObject): List<SuperHero> {
        return marvelResponseObject.data.results.map { mapItem(it) }
    }

    private fun mapItem(superHeroRemote: SuperHeroRemote): SuperHero {
        return SuperHero(
            id = superHeroRemote.id,
            name = superHeroRemote.name,
            photo = "${superHeroRemote.thumbnail.path}.${superHeroRemote.thumbnail.extension}",
            description = superHeroRemote.description,
            favorite = false // todo: not sure to do this... leave off?
        )
    }
}

class SeriesRemoteToPresentationMapper @Inject constructor() {

    fun mapList(seriesRemote: SeriesRemote): List<SeriesPresent> {
        return seriesRemote.data.results.map { mapItem(it) }
    }

    private fun mapItem(seriesResult: SeriesResult): SeriesPresent {
        return SeriesPresent(
            id = seriesResult.id,
            title = seriesResult.title,
            photo = "${seriesResult.thumbnail.path}.${seriesResult.thumbnail.extension}",
            description = seriesResult.description
        )
    }
}

class ComicsRemoteToPresentationMapper @Inject constructor() {

    fun mapList(comicsRemote: ComicsRemote): List<ComicsPresent> {
        return comicsRemote.data.results.map { mapItem(it) }
    }

    private fun mapItem(comics: ComicsResult): ComicsPresent {
        return ComicsPresent(
            id = comics.id,
            title = comics.title,
            photo = "${comics.thumbnail.path}.${comics.thumbnail.extension}",
            description = comics.description
        )
    }
}