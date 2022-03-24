package com.example.quizapp.presentation.startFragment

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.quizapp.R
import com.example.quizapp.core.BaseFragment
import com.example.quizapp.databinding.FragmentStartBinding
import com.example.quizapp.domain.start.entity.CategoryEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class StartFragment: BaseFragment<FragmentStartBinding>() {

    private val viewModel: StartViewModel by viewModels()

    override fun bind(): FragmentStartBinding {
        return FragmentStartBinding.inflate(layoutInflater)
    }

    override fun setupListeners(){
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.txtAmountValue.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        binding.btnStart.setOnClickListener{
            openGameFragment()

        }
    }

    private fun openGameFragment() {
        val category = binding.spinnerCategory.selectedItem as CategoryEntity
        val categoryId = category.id
        val categoryName = category.name
        val count = binding.txtAmountValue.text.toString().toInt()
        val difficulty = binding.spinnerDiff.selectedItem.toString()

        val bundle = Bundle()
        bundle.apply {
            putInt(QUESTIONS_AMOUNT,count)
            putInt(CATEGORY_ID,categoryId)
            putString(CATEGORY_NAME,categoryName)
            putString(DIFFICULTY,difficulty)
        }

        val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        navController.navigate(R.id.gameFragment,bundle)
    }

    override fun setupObservers() {

        viewModel.categoryList.flowWithLifecycle(
            lifecycle,
            Lifecycle.State.STARTED
        ).onEach {
            handleCategory(it)

        }.launchIn(lifecycleScope)

    }

    private fun handleCategory(categoryList: List<CategoryEntity>){
        val listCategory: ArrayList<CategoryEntity> = ArrayList()
        listCategory.add(CategoryEntity(-1,"any categories"))

        categoryList.forEach{
            listCategory.add(it)
        }

        val adapter: ArrayAdapter<CategoryEntity> =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                listCategory
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategory.adapter = adapter

    }
    private fun setupSpinnerDifficult() {
        val listForDiffSpinner: ArrayList<String> = ArrayList()
        listForDiffSpinner.add("Any Difficulty")
        listForDiffSpinner.add("Easy")
        listForDiffSpinner.add("Medium")
        listForDiffSpinner.add("Hardy")

        val adapter: ArrayAdapter<String> =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                listForDiffSpinner
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDiff.adapter = adapter

    }
    override fun setupUi() {
        setupSpinnerDifficult()
    }

    companion object {
        const val CATEGORY_ID = "CATEGORY_ID"
        const val CATEGORY_NAME = "CATEGORY_NAME"
        const val QUESTIONS_AMOUNT = "QUESTIONS_AMOUNT"
        const val DIFFICULTY = "DIFFICULTY"
    }

}