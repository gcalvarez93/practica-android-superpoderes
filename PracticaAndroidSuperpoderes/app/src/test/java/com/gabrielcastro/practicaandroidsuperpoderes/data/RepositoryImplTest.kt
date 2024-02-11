package com.gabrielcastro.practicaandroidsuperpoderes.data

import com.gabrielcastro.practicaandroidsuperpoderes.data.local.LocalDataSource
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroDAO
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroLocal
import com.gabrielcastro.practicaandroidsuperpoderes.data.mappers.RemoteToLocalMapper
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.RemoteDataSource
import com.gabrielcastro.practicaandroidsuperpoderes.data.repository.RepositoryImpl
import com.gabrielcastro.practicaandroidsuperpoderes.fakes.FakeDao
import com.gabrielcastro.practicaandroidsuperpoderes.utils.generateSuperHeroLocalListFlow
import com.gabrielcastro.practicaandroidsuperpoderes.utils.generateSuperHeroSingle
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class) class RepositoryImplTest {

    // SUT
    private lateinit var repositoryImpl: RepositoryImpl

    // DEPENDENCIES
    lateinit var localDataSource: LocalDataSource
    lateinit var remoteDataSource: RemoteDataSource
    lateinit var remoteToLocalMapper: RemoteToLocalMapper
    lateinit var dao: SuperHeroDAO

    @Before
    fun setUp() {
    }

    @Test
    fun `(TO_LIST VERSION) WHEN getLocalHeros successful EXPECTS list not empty`() = runTest{
        // GIVEN
        localDataSource = mockk()
        remoteDataSource = mockk()
        remoteToLocalMapper = RemoteToLocalMapper()
        dao = FakeDao(false)
        coEvery { localDataSource.getHeroes3() } returns generateSuperHeroLocalListFlow()

        repositoryImpl = RepositoryImpl(localDataSource, remoteDataSource, remoteToLocalMapper, dao)

        // WHEN
        val actual = repositoryImpl.getHeroes4().toList()

        // THEN
        assert(actual.first().isNotEmpty())
    }

    @Test
    fun `(COLLECT VERSION) WHEN getLocalHeroes successful EXPECTS not working`() = runTest{
        // GIVEN
        localDataSource = mockk()
        remoteDataSource = mockk()
        remoteToLocalMapper = RemoteToLocalMapper()
        dao = FakeDao(false)
        coEvery { localDataSource.getHeroes3() } returns generateSuperHeroLocalListFlow()

        repositoryImpl = RepositoryImpl(localDataSource, remoteDataSource, remoteToLocalMapper, dao)

        // WHEN
        val actual = repositoryImpl.getHeroes4()
        (dao as FakeDao).emit(listOf(SuperHeroLocal(123, "name1", "photo1", "Description1",false)))


        actual.collect {
            assert(it.isNotEmpty())
        }
    }

    @After
    fun tearDown() {
    }
}
