package com.example.androidsamplecalculator

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun OperatorButton(operator: String, onTap: (String) -> Unit) {
    Button(onClick = { onTap(operator) }) {
        Text(text = operator)
    }
}