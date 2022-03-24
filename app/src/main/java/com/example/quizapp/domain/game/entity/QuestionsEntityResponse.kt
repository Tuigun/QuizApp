package com.example.quizapp.domain.start.entity


import com.google.gson.annotations.SerializedName

data class QuestionsEntityResponse(
    @SerializedName("response_code")
    val responseCode: Int?,
    @SerializedName("results")
    val results: List<QuestionsEntity>
)
    data class QuestionsEntity(
        @SerializedName("category")
        val category: String?,
        @SerializedName("correct_answer")
        val correctAnswer: String?,
        @SerializedName("difficulty")
        val difficulty: String?,
        @SerializedName("incorrect_answers")
        val incorrectAnswers: List<String>?,
        @SerializedName("question")
        val question: String?,
        @SerializedName("type")
        val type: String?
    )
