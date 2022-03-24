package com.example.quizapp.di

import com.example.quizapp.domain.start.repository.StartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.quizapp.data.start.remote.StartApi
import com.example.quizapp.domain.start.remote.StartRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [NetWorkModule::class])
@InstallIn(SingletonComponent::class)
class StartModule {

    @Singleton
    @Provides
    fun provideStartApi(retrofit: Retrofit): StartApi {
        return retrofit.create(StartApi::class.java)

    }

    @Singleton
    @Provides
    fun provideStartRepository(startApi: StartApi): StartRepository{
        return StartRepositoryImpl(startApi)
    }
}