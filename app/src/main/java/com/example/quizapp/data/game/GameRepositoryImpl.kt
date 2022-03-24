package com.example.quizapp.data.game

import com.example.quizapp.core.BaseResult
import com.example.quizapp.data.game.remote.GameApi
import com.example.quizapp.domain.game.repository.GameRepository
import com.example.quizapp.domain.start.entity.QuestionsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val gameApi: GameApi): GameRepository {
    override suspend fun getQstns(
        amount: Int,
        category: Int,
        diff: String
    ): Flow<BaseResult<List<QuestionsEntity>, String>> {
        return flow {
            val response = gameApi.getQstns(amount, category,diff)
            if (response.isSuccessful){
                val body = response.body()
                body?.results?.let { emit(BaseResult.Success(it)) }
            }
            else {
                emit(BaseResult.Error(response.message()))
            }
        }
    }
}