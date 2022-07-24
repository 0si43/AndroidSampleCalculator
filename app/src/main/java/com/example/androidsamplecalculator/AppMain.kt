package com.example.androidsamplecalculator

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.remember
import androidx.compose.material3.*
import androidx.compose.runtime.*

enum class Operator(val symbol: String) {
    PLUS("+") {
        override fun calculate(lhs: Int, rhs: Int): Int {
            return lhs + rhs
        }
    },
    MINUS("-"){
        override fun calculate(lhs: Int, rhs: Int): Int {
            return lhs - rhs
        }
    },
    MULTIPLY("*"){
        override fun calculate(lhs: Int, rhs: Int): Int {
            return lhs * rhs
        }
    },
    DIVIDE("/"){
        override fun calculate(lhs: Int, rhs: Int): Int {
            return lhs / rhs
        }
    };

    abstract fun calculate(lhs: Int, rhs: Int): Int
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
        var operator: Operator? by remember { mutableStateOf(null) }
        val onTapOperator: (Operator) -> Unit = {
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
                result = operator?.calculate(lhs, rhs).toString()
                savedNumber = ""
                operator = null
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
            OperatorButton(operator = Operator.DIVIDE, onTap = onTapOperator)
        }
        Row() {
            NumberButton(number = 7, onTap = onTapNumber)
            NumberButton(number = 8, onTap = onTapNumber)
            NumberButton(number = 9, onTap = onTapNumber)
            OperatorButton(operator = Operator.MULTIPLY, onTap = onTapOperator)
        }
        Row() {
            NumberButton(number = 4, onTap = onTapNumber)
            NumberButton(number = 5, onTap = onTapNumber)
            NumberButton(number = 6, onTap = onTapNumber)
            OperatorButton(operator = Operator.MINUS, onTap = onTapOperator)
        }
        Row() {
            NumberButton(number = 1, onTap = onTapNumber)
            NumberButton(number = 2, onTap = onTapNumber)
            NumberButton(number = 3, onTap = onTapNumber)
            OperatorButton(operator = Operator.PLUS, onTap = onTapOperator)
        }
        Row() {
            NumberButton(number = 0, onTap = onTapNumber)
            EmptyButton()
            DeleteButton(onTap = onTapDelete)
            EqualButton(onTap = onTapEqual)
        }
    }
}