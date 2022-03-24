package com.example.quizapp.presentation.setting

import com.example.quizapp.core.BaseFragment
import com.example.quizapp.databinding.FragmentSettingsBinding
import com.example.quizapp.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override fun bind(): FragmentSettingsBinding {
        return FragmentSettingsBinding.inflate(layoutInflater)
    }

    override fun setupListeners() {
    }

    override fun setupObservers() {
    }

    override fun setupUi() {
    }

}