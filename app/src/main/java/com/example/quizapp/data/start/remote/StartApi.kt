package com.example.quizapp.data.start.remote

import com.example.quizapp.domain.start.entity.CategoryEntityResponse
import retrofit2.Response
import retrofit2.http.GET

interface StartApi {

    @GET("api_category.php")
    suspend fun getCategoryList(): Response<CategoryEntityResponse>
}