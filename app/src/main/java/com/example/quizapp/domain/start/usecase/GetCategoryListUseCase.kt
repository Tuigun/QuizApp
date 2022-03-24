package com.example.quizapp.domain.start.usecase

import com.example.quizapp.domain.start.entity.CategoryEntity
import com.example.quizapp.domain.start.repository.StartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryListUseCase @Inject constructor(private val repository: StartRepository) {
    suspend fun invoke(): Flow<List<CategoryEntity>> = repository.getCategoryList()
}
