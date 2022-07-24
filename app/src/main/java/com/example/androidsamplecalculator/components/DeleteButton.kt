package com.example.androidsamplecalculator

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DeleteButton(onTap: () -> Unit) {
    Button(onClick = onTap) {
        Text(text = "D")
    }
}