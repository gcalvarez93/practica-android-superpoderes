package com.gabrielcastro.practicaandroidsuperpoderes.di

import com.gabrielcastro.practicaandroidsuperpoderes.data.local.LocalDataSource
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.LocalDataSourceImpl
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.RemoteDataSource
import com.gabrielcastro.practicaandroidsuperpoderes.data.remote.RemoteDataSourceImpl
import com.gabrielcastro.practicaandroidsuperpoderes.data.repository.Repository
import com.gabrielcastro.practicaandroidsuperpoderes.data.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

}
