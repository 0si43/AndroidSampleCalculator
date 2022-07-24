package com.example.androidsamplecalculator

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ClearButton(onTap: () -> Unit) {
    Button(onClick = onTap) {
        Text(text = "C")
    }
}
