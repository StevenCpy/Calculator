package com.example.calculatorproject

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/*
data class CalculatorState (
    var num1 : String = "",
    var num2 : String = "",
    var operation : String = "",
    var numIsDecimal : Boolean = false,     // true if the current number being entered has a decimal point
    var numEnabled : Boolean = true,        // true if Number buttons [0-9] are enabled
    var operatorEnabled : Boolean = false,  // true if Operator buttons [+,-,*,/] are enabled
    var equalEnabled : Boolean = false,     // true if Equal button [=] is enabled
    var signEnabled : Boolean = true,       // true if Sign button [+/-] is enabled
    var decimalEnabled : Boolean = false,   // true if Decimal point button [.] is enabled
    var clearEnabled : Boolean = true       // true if Clear button [C] is enabled
)
 */

data class CalculatorState (
    var num1 : String = "",
    var num2 : String = "",
    var operation : String = "",
    var numIsDecimal : Boolean = false,     // true if the current number being entered has a decimal point
    var numEnabled : Boolean = true,        // true if Number buttons [0-9] are enabled
    var operatorEnabled : Boolean = false,  // true if Operator buttons [+,-,*,/] are enabled
    var equalEnabled : Boolean = false,     // true if Equal button [=] is enabled
    var signEnabled : Boolean = true,       // true if Sign button [+/-] is enabled
    var decimalEnabled : Boolean = false,   // true if Decimal point button [.] is enabled
    var clearEnabled : Boolean = true       // true if Clear button [C] is enabled
)