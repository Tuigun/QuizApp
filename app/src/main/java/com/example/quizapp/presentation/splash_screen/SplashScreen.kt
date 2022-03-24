package com.example.quizapp.presentation.splash_screen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.presentation.activity.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}