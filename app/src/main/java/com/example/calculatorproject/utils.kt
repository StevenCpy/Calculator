package com.example.calculatorproject

import android.util.Log

// isNegative() returns true if expr represents a negative number
fun isNegative(expr : String) : Boolean {
    if (expr.isNotEmpty()) {
        if (expr[0] == '-') return true
    }
    return false
}

// isDecimal() returns true if expr represents a decimal number
fun isDecimal(expr : String) : Boolean {
    if (expr.isNotEmpty()) {
        if (expr.contains('.')) return true
    }
    return false
}

// addCommas() return a string containing commas added to expr
fun addCommas(expr : String) : String {
    val isNegative = isNegative(expr)
    var isDecimal = isDecimal(expr)
    var returnString = ""
    Log.d("test", "path")

    var i = expr.length-1
    while (i >= 0) {
        if (isDecimal) {
            if (expr[i] == '.') {
                isDecimal = false
            }
            returnString = expr[i] + returnString
            i -= 1
            continue
        }

        if (i-2 > 0) {  // out of bounds
            if (isNegative) {   // expr has a negative sign at the start
                if (i-3 == 0) {
                    returnString = expr.substring(0,i+1) + returnString
                    break
                }
            } else {
                returnString = "," + expr.substring(i-2,i+1)  + returnString
                i -= 3
            }
        } else {
            returnString = expr.substring(0,i+1) + returnString
            break
        }
    }
    return returnString
}