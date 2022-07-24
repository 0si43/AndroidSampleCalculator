package com.example.androidsamplecalculator

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NumberButton(number: Int, onTap: (Int) -> Unit) {
    Button(onClick = { onTap(number) } ) {
        Text(text = number.toString())
    }
}