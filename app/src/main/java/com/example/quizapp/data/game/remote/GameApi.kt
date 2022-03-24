package com.example.quizapp.data.game.remote

import com.example.quizapp.domain.start.entity.QuestionsEntityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET("api.php")
    suspend fun getQstns(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") diff: String
    ): Response<QuestionsEntityResponse>
}