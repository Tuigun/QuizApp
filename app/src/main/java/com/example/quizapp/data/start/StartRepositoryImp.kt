package com.example.quizapp.domain.start.remote

import com.example.quizapp.data.start.remote.StartApi
import com.example.quizapp.domain.start.entity.CategoryEntity
import com.example.quizapp.domain.start.repository.StartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StartRepositoryImpl @Inject constructor(private val startApi: StartApi) : StartRepository {

    override suspend fun getCategoryList(): Flow<List<CategoryEntity>> {
        return flow {
            val response = startApi.getCategoryList()
            if (response.isSuccessful){
                val body = response.body()
                body?.triviaCategories?.let { emit(it) }

            }

        }
    }

}