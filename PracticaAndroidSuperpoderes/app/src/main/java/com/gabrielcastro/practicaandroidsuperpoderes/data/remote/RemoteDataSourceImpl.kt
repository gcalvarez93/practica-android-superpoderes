package com.gabrielcastro.practicaandroidsuperpoderes.data.remote

import com.gabrielcastro.practicaandroidsuperpoderes.SeriesRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.MarvelApi
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.ComicsRemote
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.MarvelResponseObject
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.response.SuperHeroRemote
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MarvelApi): RemoteDataSource {

    val apikey: String = "4d72502ffbd31d392959cf1d389e69f3"
    val hash: String = "f9ee188b78e178164a3a95b0f22618c5"

    override suspend fun getHeroes2(): MarvelResponseObject {
        return api.getHeroes1(1,apikey, hash, 5, 400) // 3, 800
    }

    override suspend fun getHeroByName2(name: String): MarvelResponseObject {
        return api.getHeroByName1(1,apikey,hash, name)
    }
    override suspend fun getSeries2(id: Long): SeriesRemote {
        return api.getSeries1(id,1,apikey,hash,3)
    }

    override suspend fun getComics2(id: Long): ComicsRemote {
        return api.getComics1(id,1,apikey,hash,2)
    }
    suspend fun getHeroesT(): List<SuperHeroRemote> {
        val result = api.getHeroes1(1, apikey, hash, 3, 800)
        return result.data.results.filter {
            it.name.startsWith("F")
        }
    }
}