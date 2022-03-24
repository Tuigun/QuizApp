package com.example.quizapp.presentation.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.core.BaseResult
import com.example.quizapp.domain.start.entity.QuestionsEntity
import com.example.quizapp.domain.game.usecase.GetQstnsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class GameViewModel @Inject constructor(private val getQstnsUseCase: GetQstnsUseCase): ViewModel() {

    private val _qstnsList = MutableStateFlow<List<QuestionsEntity>>(mutableListOf())
    val qstnList: StateFlow<List<QuestionsEntity>> get() = _qstnsList

    private val _state = MutableStateFlow<GameFragmentState>(GameFragmentState.Init)
    val state: StateFlow<GameFragmentState> get() = _state


    private fun fetchQuestn(amount: Int, category: Int, diff: String) {
        viewModelScope.launch {
            getQstnsUseCase.invoke(amount,category,diff)
                .onStart {
                    setLoading()

                }
                .catch {
                    hideLoading()
                    showToast(it.message ?:"")

                }
                .collect{
                    when(it){
                        is BaseResult.Success -> {


                        }
                        is BaseResult.Error -> {
                            showToast(it.errorMsg)

                        }
                    }
                }
        }
    }

    private fun showToast(message: String) {
        _state.value = GameFragmentState.ShowToast(message)
    }

    private fun hideLoading() {
        _state.value = GameFragmentState.IsLoading(false)
    }

    private fun setLoading() {
        _state.value = GameFragmentState.IsLoading(true)
    }

    sealed class GameFragmentState(){
        object Init: GameFragmentState()
        data class IsLoading(val isLoading: Boolean ): GameFragmentState()
        data class ShowToast(val massage: String): GameFragmentState()
    }

}