package com.example.quizapp.domain.start.repository

import com.example.quizapp.domain.start.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface StartRepository {

    suspend fun getCategoryList(): Flow<List<CategoryEntity>>

}