package com.example.calculatorproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorproject.ui.theme.CalculatorProjectTheme

@Composable
fun ButtonLayout(calculatorState: CalculatorState) {
    @Composable
    fun rowSpacing() { Spacer(modifier = Modifier.height(5.dp)) }

    @Composable
    fun columnSpacing() { Spacer(modifier = Modifier.width(5.dp)) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val text = calculatorState.num1.value + calculatorState.operation.value + calculatorState.num2.value
        Row (modifier = Modifier
            .width(360.dp)
            .height(90.dp)
            .background(color = Color.LightGray)) {
            Text(text, fontSize = 30.sp)
        }
        rowSpacing()
        Row {
            CalculatorButton("C", calculatorState,
                Modifier
                    .width(270.dp)
                    .height(90.dp)) { CalculatorAction().clear(calculatorState) }
            columnSpacing()
            CalculatorButton("+", calculatorState) { CalculatorAction().operator("+", calculatorState) }
        }
        rowSpacing()
        Row {
            CalculatorButton("7", calculatorState) { CalculatorAction().appendDigit("7", calculatorState) }
            columnSpacing()
            CalculatorButton("8", calculatorState) { CalculatorAction().appendDigit("8", calculatorState) }
            columnSpacing()
            CalculatorButton("9", calculatorState) { CalculatorAction().appendDigit("9", calculatorState) }
            columnSpacing()
            CalculatorButton("-", calculatorState) { CalculatorAction().operator("-", calculatorState) }
        }
        rowSpacing()
        Row {
            CalculatorButton("4", calculatorState) { CalculatorAction().appendDigit("4", calculatorState) }
            columnSpacing()
            CalculatorButton("5", calculatorState) { CalculatorAction().appendDigit("5", calculatorState) }
            columnSpacing()
            CalculatorButton("6", calculatorState) { CalculatorAction().appendDigit("6", calculatorState) }
            columnSpacing()
            CalculatorButton("x", calculatorState) { CalculatorAction().operator("*", calculatorState) }
        }
        rowSpacing()
        Row {
            CalculatorButton("1", calculatorState) { CalculatorAction().appendDigit("1", calculatorState) }
            columnSpacing()
            CalculatorButton("2", calculatorState) { CalculatorAction().appendDigit("2", calculatorState) }
            columnSpacing()
            CalculatorButton("3", calculatorState) { CalculatorAction().appendDigit("3", calculatorState) }
            columnSpacing()
            CalculatorButton("%", calculatorState) { CalculatorAction().operator("/", calculatorState) }
        }
        rowSpacing()
        Row {
            CalculatorButton("+/-", calculatorState) { CalculatorAction().sign(calculatorState) }
            columnSpacing()
            CalculatorButton("0", calculatorState) { CalculatorAction().appendDigit("0", calculatorState) }
            columnSpacing()
            CalculatorButton(".", calculatorState) { CalculatorAction().decimal(calculatorState) }
            columnSpacing()
            CalculatorButton("=", calculatorState) { CalculatorAction().equal(calculatorState) }
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorProjectTheme {
                //val calculatorState : CalculatorState = CalculatorState()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val calculatorState by remember { mutableStateOf(CalculatorState()) }
                    ButtonLayout(calculatorState)
                }
            }
        }
    }
}