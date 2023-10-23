package com.example.calculatorproject

import java.text.DecimalFormat

class CalculatorAction {
    fun appendDigit(digit : String, calculatorState: CalculatorState) {
        if (calculatorState.operation.value == "") {  // append digit to num1
            calculatorState.num1.value += digit
        } else {    // append digit to num 2
            calculatorState.num2.value += digit
        }
        // when pressing a Number button,
        // Sign and Equal buttons enabled
        calculatorState.signEnabled.value = true
        calculatorState.equalEnabled.value = true
        if (!calculatorState.numIsDecimal.value) {  // Current number is not a decimal
            // Decimal button enabled
            calculatorState.decimalEnabled.value = true
        }
        // Operator button enabled
        if (calculatorState.operation.value == "") {
            calculatorState.operatorEnabled.value = true
        }
    }

    fun operator(operator : String, calculatorState: CalculatorState) {
        calculatorState.operation.value = operator
        // when pressing an Operator button,
        // Number and Sign buttons enabled
        // Operator, Decimal and Equal buttons disabled
        calculatorState.numEnabled.value = true; calculatorState.signEnabled.value = true
        calculatorState.operatorEnabled.value = false; calculatorState.decimalEnabled.value = false; calculatorState.equalEnabled.value = false
    }

    fun sign(calculatorState: CalculatorState) {
        if (calculatorState.operation.value == "") {  // change sign of num1
            if (calculatorState.num1.value == "") {   // add sign before typing num2
                calculatorState.num1.value = "-"
            } else {    // change sign of num1
                if (calculatorState.num1.value[0] == '-') {
                    calculatorState.num1.value = calculatorState.num1.value.drop(1)
                } else {
                    calculatorState.num1.value = "-" + calculatorState.num1.value
                }
            }
        } else {    // change sign of num2
            if (calculatorState.num2.value == "") {   // add sign before typing num2
                calculatorState.num2.value = "-"
            } else {    // change sign of num2
                if (calculatorState.num2.value[0] == '-') {
                    calculatorState.num2.value = calculatorState.num2.value.drop(1)
                } else {
                    calculatorState.num2.value = "-" + calculatorState.num2.value
                }
            }
        }
    }

    fun equal(calculatorState: CalculatorState) {
        val result : Double = when (calculatorState.operation.value) {
            "+" -> calculatorState.num1.value.toDouble() + calculatorState.num2.value.toDouble()
            "-" -> calculatorState.num1.value.toDouble() - calculatorState.num2.value.toDouble()
            "*" -> calculatorState.num1.value.toDouble() * calculatorState.num2.value.toDouble()
            "/" -> calculatorState.num1.value.toDouble() / calculatorState.num2.value.toDouble()
            else -> calculatorState.num1.value.toDouble()
        }
        // remove trailing zeros and save to num1
        calculatorState.num1.value = DecimalFormat("0.###########").format(result).toString()
        calculatorState.num2.value = ""
        calculatorState.operation.value = ""
        // when user pressed on Equal button,
        // Operator and Sign buttons enabled
        // Number and Decimal buttons disabled
        calculatorState.signEnabled.value = true; calculatorState.operatorEnabled.value = true
        calculatorState.numEnabled.value = false; calculatorState.decimalEnabled.value = false
    }

    fun decimal(calculatorState: CalculatorState) {
        if (calculatorState.operation.value == "") {
            calculatorState.num1.value += "."
        } else {
            calculatorState.num2.value += "."
        }
        calculatorState.numIsDecimal.value = true // indicate that the current number has a decimal point
        // when user presses on Decimal button,
        // Operator, Equal and Decimal buttons disabled
        calculatorState.operatorEnabled.value = false
        calculatorState.equalEnabled.value = false
        calculatorState.decimalEnabled.value = false
    }

    fun clear(calculatorState: CalculatorState) {
        calculatorState.num1.value = ""
        calculatorState.num2.value = ""
        calculatorState.operation.value = ""
        calculatorState.numIsDecimal.value = false
        // when state is cleared,
        // Number and Sign buttons enabled
        // Operator, Equal and Decimal buttons disabled
        calculatorState.numEnabled.value = true; calculatorState.signEnabled.value = true
        calculatorState.operatorEnabled.value = false; calculatorState.equalEnabled.value = false; calculatorState.decimalEnabled.value = false
    }
}