package com.example.androidsamplecalculator

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.remember
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun AppMain() {
    Column(
        modifier = Modifier.fillMaxSize()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
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

        Text(
            modifier = Modifier.fillMaxWidth()
                            .weight(1.0f),
            textAlign = TextAlign.Right,
            text = result.toString(),
            fontSize = 60.sp,
            softWrap = false,
            maxLines = 1
        )
        Row(
            modifier = Modifier.fillMaxWidth()
                            .weight(1.0f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ClearButton(modifier = Modifier.weight(1.0f), onTap = onTapClear)
            EmptyButton(modifier = Modifier.weight(1.0f))
            EmptyButton(modifier = Modifier.weight(1.0f))
            OperatorButton(modifier = Modifier.weight(1.0f), operator = Operator.DIVIDE, onTap = onTapOperator)
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(1.0f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NumberButton(modifier = Modifier.weight(1.0f), number = 7, onTap = onTapNumber)
            NumberButton(modifier = Modifier.weight(1.0f), number = 8, onTap = onTapNumber)
            NumberButton(modifier = Modifier.weight(1.0f), number = 9, onTap = onTapNumber)
            OperatorButton(modifier = Modifier.weight(1.0f), operator = Operator.MULTIPLY, onTap = onTapOperator)
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                            .weight(1.0f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NumberButton(modifier = Modifier.weight(1.0f), number = 4, onTap = onTapNumber)
            NumberButton(modifier = Modifier.weight(1.0f), number = 5, onTap = onTapNumber)
            NumberButton(modifier = Modifier.weight(1.0f), number = 6, onTap = onTapNumber)
            OperatorButton(modifier = Modifier.weight(1.0f), operator = Operator.MINUS, onTap = onTapOperator)
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                            .weight(1.0f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NumberButton(modifier = Modifier.weight(1.0f), number = 1, onTap = onTapNumber)
            NumberButton(modifier = Modifier.weight(1.0f), number = 2, onTap = onTapNumber)
            NumberButton(modifier = Modifier.weight(1.0f), number = 3, onTap = onTapNumber)
            OperatorButton(modifier = Modifier.weight(1.0f), operator = Operator.PLUS, onTap = onTapOperator)
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                            .weight(1.0f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NumberButton(modifier = Modifier.weight(1.0f), number = 0, onTap = onTapNumber)
            EmptyButton(modifier = Modifier.weight(1.0f))
            DeleteButton(modifier = Modifier.weight(1.0f), onTap = onTapDelete)
            EqualButton(modifier = Modifier.weight(1.0f), onTap = onTapEqual)
        }
    }
}
