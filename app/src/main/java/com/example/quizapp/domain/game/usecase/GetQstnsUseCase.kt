package com.example.quizapp.domain.game.usecase

import com.example.quizapp.core.BaseResult
import com.example.quizapp.domain.game.repository.GameRepository
import com.example.quizapp.domain.start.entity.QuestionsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQstnsUseCase @Inject constructor(private val repository: GameRepository) {

    suspend fun invoke(
        amount: Int,
        category: Int,
        diff: String
    ): Flow<BaseResult<List<QuestionsEntity>, String>> = repository.getQstns(amount, category, diff)
}

