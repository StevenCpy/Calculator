package com.example.calculatorproject

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CalculatorState (
    var num1 : MutableState<String> = mutableStateOf(""),
    var num2 : MutableState<String> = mutableStateOf(""),
    var operation : MutableState<String> = mutableStateOf(""),
    var numIsDecimal : MutableState<Boolean> = mutableStateOf(false),   // true if the current number being entered has a decimal point

    var numEnabled : MutableState<Boolean> = mutableStateOf(true),      // true if Number buttons [0-9] are enabled
    var operatorEnabled: MutableState<Boolean> = mutableStateOf(false), // true if Operator buttons [+,-,*,/] are enabled
    var equalEnabled : MutableState<Boolean> = mutableStateOf(false),   // true if Equal button [=] is enabled
    var signEnabled : MutableState<Boolean> = mutableStateOf(true),     // true if Sign button [+/-] is enabled
    var decimalEnabled : MutableState<Boolean> = mutableStateOf(false), // true if Decimal point button [.] is enabled
    var clearEnabled : MutableState<Boolean> = mutableStateOf(true)     // true if Clear button [C] is enabled
)