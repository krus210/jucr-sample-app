package com.example.jucrsampleapp.data.di

import com.example.jucrsampleapp.data.repository.AboutCarRepository
import com.example.jucrsampleapp.data.repository.AboutCarRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    companion object {

        @Provides
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
    }

    @Binds
    @Singleton
    fun bindAboutCarRepository(aboutCarRepositoryImpl: AboutCarRepositoryImpl): AboutCarRepository
}