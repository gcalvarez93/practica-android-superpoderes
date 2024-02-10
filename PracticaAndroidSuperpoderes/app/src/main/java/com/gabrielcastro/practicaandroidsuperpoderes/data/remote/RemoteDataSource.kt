package com.gabrielcastro.practicaandroidsuperpoderes.data.remote

import com.gabrielcastro.practicaandroidsuperpoderes.SeriesRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.ComicsRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.MarvelResponseObject

interface RemoteDataSource {
    suspend fun getHeroes2(): MarvelResponseObject
    suspend fun getHeroByName2(name: String): MarvelResponseObject
    suspend fun getSeries2(id: Long): SeriesRemote
    suspend fun getComics2(id: Long): ComicsRemote
}