package com.gabrielcastro.practicaandroidsuperpoderes.utils

import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroLocal
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.Comics
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.ComicsItem
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.Extension
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.SuperHeroRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.Thumbnail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlin.random.Random

fun generateSuperHeroRemoteList(): List<SuperHeroRemote> {
    return (0 until 5).map {
        SuperHeroRemote(
            id = Random.nextLong(),
            name = "Name $it",
            description = "Photo $it",
            thumbnail = Thumbnail("http://i.annihil.us/u/prod/marvel/i/mg/d/d0/5269657a74350",Extension.jpg),
            series = Comics(
                available = Random.nextLong(),
                collectionURI = "collectionURI $it",
                items = arrayOf(
                    ComicsItem(
                        resourceURI = "resourceURI $it",
                        name = "Name $it"
                    )
                ),
                returned = Random.nextInt()
            )
        )
    }
}

fun generateSuperHeroLocalList(): List<SuperHeroLocal> {
    return (0 until 5).map {
        SuperHeroLocal(
            id = Random.nextLong(),
            "Name $it",
            "Photo $it",
            "Description $it",
            false
        )
    }
}

val generateSuperHeroLocalListFlowHard = generateSuperHeroLocalList().asFlow()

fun generateSuperHeroLocalListFlow(): Flow<List<SuperHeroLocal>> {
    var heroListFlow: List<SuperHeroLocal>
    heroListFlow = (0 until 5).map {
        SuperHeroLocal(
            id = Random.nextLong(),
            "Name $it",
            "Photo $it",
            "Description $it",
            false
        )
    }
    return flowOf(heroListFlow)
}

fun generateSuperHeroSingle(): SuperHeroLocal {
    return SuperHeroLocal(
        id = 1009664,
        name = "Thor",
        photo = "http://i.annihil.us/u/prod/marvel/i/mg/d/d0/5269657a74350.jpg",
        description = "God of lightening",
        favorite = false
    )
}