package com.example.calculatorproject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class calculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set
}