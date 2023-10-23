package com.example.calculatorproject

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val buttonModifier = Modifier
    .size(90.dp)
    .clip(shape = CircleShape)

@Composable
fun CalculatorButton(
    symbol : String,
    calculatorState: CalculatorState,
    modifier : Modifier = buttonModifier,
    onClick : () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = when (symbol) {
            in "0".."9" -> calculatorState.numEnabled.value
            "+", "-", "x", "%" -> calculatorState.operatorEnabled.value
            "+/-" -> calculatorState.signEnabled.value
            "=" -> calculatorState.equalEnabled.value
            "." -> calculatorState.decimalEnabled.value
            else -> calculatorState.clearEnabled.value
        }
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(symbol, fontSize = 30.sp)
        }
    }
}