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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorproject.ui.theme.CalculatorProjectTheme

@Composable
fun buttonLayout(calculatorState: CalculatorState) {
    @Composable
    fun rowSpacing() { Spacer(modifier = Modifier.height(5.dp)) }

    @Composable
    fun columnSpacing() { Spacer(modifier = Modifier.width(5.dp)) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf(calculatorState.num1 + calculatorState.operation + calculatorState.num2)
        }
        Row (modifier = Modifier
            .width(360.dp)
            .height(90.dp)
            .background(color = Color.LightGray)) {
            Text(text, fontSize = 30.sp)
        }
        rowSpacing()
        Row {
            calculatorButton("C", calculatorState,
                Modifier
                    .width(270.dp)
                    .height(90.dp)) { CalculatorAction().clear(calculatorState) }
            columnSpacing()
            calculatorButton("+", calculatorState) { CalculatorAction().operator("+", calculatorState) }
        }
        rowSpacing()
        Row {
            calculatorButton("7", calculatorState) { CalculatorAction().appendDigit("7", calculatorState) }
            columnSpacing()
            calculatorButton("8", calculatorState) { CalculatorAction().appendDigit("8", calculatorState) }
            columnSpacing()
            calculatorButton("9", calculatorState) { CalculatorAction().appendDigit("9", calculatorState) }
            columnSpacing()
            calculatorButton("-", calculatorState) { CalculatorAction().operator("-", calculatorState) }
        }
        rowSpacing()
        Row {
            calculatorButton("4", calculatorState) { CalculatorAction().appendDigit("4", calculatorState) }
            columnSpacing()
            calculatorButton("5", calculatorState) { CalculatorAction().appendDigit("5", calculatorState) }
            columnSpacing()
            calculatorButton("6", calculatorState) { CalculatorAction().appendDigit("6", calculatorState) }
            columnSpacing()
            calculatorButton("x", calculatorState) { CalculatorAction().operator("*", calculatorState) }
        }
        rowSpacing()
        Row {
            calculatorButton("1", calculatorState) { CalculatorAction().appendDigit("1", calculatorState) }
            columnSpacing()
            calculatorButton("2", calculatorState) { CalculatorAction().appendDigit("2", calculatorState) }
            columnSpacing()
            calculatorButton("3", calculatorState) { CalculatorAction().appendDigit("3", calculatorState) }
            columnSpacing()
            calculatorButton("%", calculatorState) { CalculatorAction().operator("/", calculatorState) }
        }
        rowSpacing()
        Row {
            calculatorButton("+/-", calculatorState) { CalculatorAction().sign(calculatorState) }
            columnSpacing()
            calculatorButton("0", calculatorState) { CalculatorAction().appendDigit("0", calculatorState) }
            columnSpacing()
            calculatorButton(".", calculatorState) { CalculatorAction().decimal(calculatorState) }
            columnSpacing()
            calculatorButton("=", calculatorState) { CalculatorAction().equal(calculatorState) }
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
                    var calculatorState by remember { mutableStateOf(CalculatorState()) }
                    calculatorState.signEnabled = true
                    buttonLayout(calculatorState)
                }
            }
        }
    }
}