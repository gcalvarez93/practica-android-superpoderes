package com.gabrielcastro.practicaandroidsuperpoderes.data

import com.gabrielcastro.practicaandroidsuperpoderes.data.local.LocalDataSource
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroDAO
import com.gabrielcastro.practicaandroidsuperpoderes.data.mappers.RemoteToLocalMapper
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.FakeRemoteDataSource
import com.gabrielcastro.practicaandroidsuperpoderes.data.repository.RepositoryImpl
import com.gabrielcastro.practicaandroidsuperpoderes.ui.heroSample
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class RepositoryImplWithFakesTest {

    // SUT
    private lateinit var repositoryImpl: RepositoryImpl
    private lateinit var localDataSource: LocalDataSource
    private val fakeRemoteDataSource = FakeRemoteDataSource()
    private lateinit var dao: SuperHeroDAO

    @Before
    fun setUpMocks() {
        localDataSource = mockk()
        dao = mockk()
        repositoryImpl = RepositoryImpl(
            localDataSource,
            fakeRemoteDataSource,
            RemoteToLocalMapper(),
            dao
        )
    }

    @Test
    fun `WHEN getHeroByName4 EXPECT success and return SuperHeroLocal` () = runTest {

        // Given
        val expectedHeroLocal = heroSample
        coEvery { localDataSource.getHeroByName3(1009664) } returns expectedHeroLocal

        // When
        val actual = repositoryImpl.getHeroByName4(1009664)

        // Then
        Truth.assertThat(actual).isNotNull()
        Truth.assertThat(actual?.id).isEqualTo(1009664)
    }
}