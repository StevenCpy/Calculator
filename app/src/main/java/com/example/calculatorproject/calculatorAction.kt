package com.example.calculatorproject

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import java.text.DecimalFormat

class CalculatorAction {
    fun appendDigit(digit : String, calculatorState: CalculatorState) {
        if (calculatorState.operation == "") {  // append digit to num1
            calculatorState.num1 += digit
        } else {    // append digit to num 2
            calculatorState.num2 += digit
        }
        // when pressing a Number button,
        // Sign and Decimal buttons enabled
        calculatorState.copy(decimalEnabled = true)
        //calculatorState.signEnabled = true
        if (!calculatorState.numIsDecimal) {
            calculatorState.copy(decimalEnabled = true)
            //calculatorState.decimalEnabled = true
        }
    }

    fun operator(operator : String, calculatorState: CalculatorState) {
        calculatorState.operation = operator
        // when pressing an Operator button,
        // Number and Sign buttons enabled
        // Operator, Decimal and Equal buttons disabled
        calculatorState.numEnabled = true; calculatorState.signEnabled = true
        calculatorState.operatorEnabled = false; calculatorState.decimalEnabled = false; calculatorState.equalEnabled = false
    }

    fun sign(calculatorState: CalculatorState) {
        if (calculatorState.operation == "") {  // change sign of num1
            if (calculatorState.num1 == "") {   // add sign before typing num2
                calculatorState.num1 = "-"
            } else {    // change sign of num1
                if (calculatorState.num1[0] == '-') {
                    calculatorState.num1 = calculatorState.num1.drop(1)
                } else {
                    calculatorState.num1 = "-" + calculatorState.num1
                }
            }
        } else {    // change sign of num2
            if (calculatorState.num2 == "") {   // add sign before typing num2
                calculatorState.num2 = "-"
            } else {    // change sign of num2
                if (calculatorState.num2[0] == '-') {
                    calculatorState.num2 = calculatorState.num2.drop(1)
                } else {
                    calculatorState.num2 = "-" + calculatorState.num2
                }
            }
        }
    }

    fun equal(calculatorState: CalculatorState) {
        val result : Double = when (calculatorState.operation) {
            "+" -> calculatorState.num1.toDouble() + calculatorState.num2.toDouble()
            "-" -> calculatorState.num1.toDouble() - calculatorState.num2.toDouble()
            "*" -> calculatorState.num1.toDouble() * calculatorState.num2.toDouble()
            "/" -> calculatorState.num1.toDouble() / calculatorState.num2.toDouble()
            else -> calculatorState.num1.toDouble()
        }
        // remove trailing zeros and save to num1
        calculatorState.num1 = DecimalFormat("0.###############").format(result).toString()
        calculatorState.num2 = ""
        calculatorState.operation = ""
        // when user pressed on Equal button,
        // Sign button enabled
        // Operator and Equal buttons disabled
        calculatorState.signEnabled = true
        calculatorState.operatorEnabled = false; calculatorState.equalEnabled = false
    }

    fun decimal(calculatorState: CalculatorState) {
        if (calculatorState.operation == "") {
            calculatorState.num1 += "."
        } else {
            calculatorState.num2 += "."
        }
        calculatorState.numIsDecimal = true // indicate that the current number has a decimal point
        // when user presses on Decimal button,
        // Operator, Equal and Decimal buttons disabled
        calculatorState.operatorEnabled = false
        calculatorState.equalEnabled = false
        calculatorState.decimalEnabled = false
    }

    fun clear(calculatorState: CalculatorState) {
        calculatorState.num1 = ""
        calculatorState.num2 = ""
        calculatorState.operation = ""
        calculatorState.numIsDecimal = false
        // when state is cleared,
        // Number and Sign buttons enabled
        // Operator, Equal and Decimal buttons disabled
        calculatorState.numEnabled = true; calculatorState.signEnabled = true
        calculatorState.operatorEnabled = false; calculatorState.equalEnabled = false; calculatorState.decimalEnabled = false
    }
}