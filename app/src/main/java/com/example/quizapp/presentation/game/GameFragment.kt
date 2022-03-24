package com.example.quizapp.presentation.game

import com.example.quizapp.core.BaseFragment
import com.example.quizapp.databinding.FragmentGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameFragment : BaseFragment<FragmentGameBinding>() {
    override fun bind(): FragmentGameBinding {
        return FragmentGameBinding.inflate(layoutInflater)
    }

    override fun setupListeners() {
    }

    override fun setupObservers() {
    }

    override fun setupUi() {
    }


}