package com.example.androidsamplecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.remember
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsamplecalculator.ui.theme.AndroidSampleCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidSampleCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppMain()
                }
            }
        }
    }
}

@Composable
fun AppMain() {
    Column() {
        var result by remember { mutableStateOf("") }
        val onTapNumber: (Int) -> Unit = {
            if (result != "" || it != 0) {
                result += it.toString()
            }
        }
        var savedNumber by remember { mutableStateOf("") }
        var operator by remember { mutableStateOf("") }
        val onTapOperator: (String) -> Unit = {
            if (savedNumber.isEmpty()) {
                savedNumber = result
                result = ""
                operator = it
            }
        }
        val onTapEqual: () -> Unit = {
            if (!savedNumber.isEmpty()) {
                val lhs = savedNumber.toIntOrNull() ?: 0
                val rhs = result.toIntOrNull() ?: 0
                when (operator) {
                    "+" -> result = (lhs + rhs).toString()
                    "-" -> result = (lhs - rhs).toString()
                    "*" -> result = (lhs * rhs).toString()
                    "/" -> result = (lhs / rhs).toString()
                }
                savedNumber = ""
                operator = ""
            }
        }

        val onTapDelete: () -> Unit = {
            if (!result.isEmpty()) {
                result = result.dropLast(1)
            }
        }

        val onTapClear: () -> Unit = {
            if (!result.isEmpty()) {
                result = ""
            }
        }

        Text(text = result.toString())
        Row() {
            ClearButton(onTap = onTapClear)
            EmptyButton()
            EmptyButton()
            OperatorButton(operator = "/", onTap = onTapOperator)
        }
        Row() {
            NumberButton(number = 7, onTap = onTapNumber)
            NumberButton(number = 8, onTap = onTapNumber)
            NumberButton(number = 9, onTap = onTapNumber)
            OperatorButton(operator = "*", onTap = onTapOperator)
        }
        Row() {
            NumberButton(number = 4, onTap = onTapNumber)
            NumberButton(number = 5, onTap = onTapNumber)
            NumberButton(number = 6, onTap = onTapNumber)
            OperatorButton(operator = "-", onTap = onTapOperator)
        }
        Row() {
            NumberButton(number = 1, onTap = onTapNumber)
            NumberButton(number = 2, onTap = onTapNumber)
            NumberButton(number = 3, onTap = onTapNumber)
            OperatorButton(operator = "+", onTap = onTapOperator)
        }
        Row() {
            NumberButton(number = 0, onTap = onTapNumber)
            EmptyButton()
            DeleteButton(onTap = onTapDelete)
            EqualButton(onTap = onTapEqual)
        }
    }
}

@Composable
fun NumberButton(number: Int, onTap: (Int) -> Unit) {
    Button(onClick = { onTap(number) } ) {
        Text(text = number.toString())
    }
}

@Composable
fun EmptyButton() {
    Button(onClick = { }) {
        Text(text = "")
    }
}

@Composable
fun OperatorButton(operator: String, onTap: (String) -> Unit) {
    Button(onClick = { onTap(operator) }) {
        Text(text = operator)
    }
}

@Composable
fun EqualButton(onTap: () -> Unit) {
    Button(onClick = onTap) {
        Text(text = "=")
    }
}

@Composable
fun ClearButton(onTap: () -> Unit) {
    Button(onClick = onTap) {
        Text(text = "C")
    }
}

@Composable
fun DeleteButton(onTap: () -> Unit) {
    Button(onClick = onTap) {
        Text(text = "D")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidSampleCalculatorTheme {
        AppMain()
    }
}