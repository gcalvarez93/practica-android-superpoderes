package com.gabrielcastro.practicaandroidsuperpoderes.data.repository

import com.gabrielcastro.practicaandroidsuperpoderes.SeriesRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroLocal
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.ComicsRemote
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getHeroes4(): Flow<List<SuperHeroLocal>>
    suspend fun insertHero(hero: SuperHeroLocal)
    suspend fun getHeroByName4(id: Long): SuperHeroLocal
    suspend fun getSeries4(id: Long): SeriesRemote
    suspend fun getComics4(id: Long): ComicsRemote
    suspend fun insertFav(superHeroLocal: SuperHeroLocal)
    suspend fun deleteFav(superHeroLocal: SuperHeroLocal)
//    suspend fun countFavs(superHeroLocalList: List<SuperHeroLocal>): Int
}