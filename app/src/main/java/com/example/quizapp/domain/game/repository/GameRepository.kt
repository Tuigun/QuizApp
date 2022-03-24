package com.example.quizapp.domain.game.repository

import com.example.quizapp.core.BaseResult
import com.example.quizapp.domain.start.entity.QuestionsEntity
import kotlinx.coroutines.flow.Flow


interface GameRepository {
    suspend fun getQstns(
        amount: Int,
        category: Int,
        diff: String
    ): Flow<BaseResult<List<QuestionsEntity>, String>>
}