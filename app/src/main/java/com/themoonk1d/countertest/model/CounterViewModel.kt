package com.themoonk1d.countertest.model

import androidx.lifecycle.ViewModel
import com.themoonk1d.countertest.state.CounterUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CounterUIState())
    val uiState: StateFlow<CounterUIState> = _uiState.asStateFlow()
    private var counterValue: Int = 0

    init {
        setUp()
    }

    fun incCounter() {
        updateState(++counterValue)
    }

    fun rstCounter() {
        setUp()
    }

    fun decCounter() {
        if (counterValue > 0) {
            updateState(--counterValue)
        }
    }

    private fun setUp() {
        counterValue = 0
        updateState(counterValue)
    }

    private fun updateState(value: Int) {
        _uiState.update {
            it.copy(counter = value)
        }
    }
}
