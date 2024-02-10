package com.gabrielcastro.practicaandroidsuperpoderes.di

import android.content.Context
import androidx.room.Room
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroDAO
import com.gabrielcastro.practicaandroidsuperpoderes.data.local.SuperHeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SuperHeroDatabase {
        return Room.databaseBuilder(
            context,
            SuperHeroDatabase::class.java, "database-name"
        ).build()
    }

    @Provides
    fun provideDao(database: SuperHeroDatabase): SuperHeroDAO {
        return database.getDAO()
    }
}