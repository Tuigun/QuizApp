package com.example.quizapp.di.game

import com.example.quizapp.data.game.GameRepositoryImpl
import com.example.quizapp.data.game.remote.GameApi
import com.example.quizapp.di.NetWorkModule
import com.example.quizapp.domain.game.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes =[NetWorkModule::class])
@InstallIn(SingletonComponent::class)
class GameModule {

    @Singleton
    @Provides
    fun providesGameApi(retrofit: Retrofit): GameApi {
        return retrofit.create(GameApi::class.java)
    }

    @Singleton
    @Provides
    fun providesRepository(gameApi: GameApi): GameRepository {
        return GameRepositoryImpl(gameApi)
    }


}