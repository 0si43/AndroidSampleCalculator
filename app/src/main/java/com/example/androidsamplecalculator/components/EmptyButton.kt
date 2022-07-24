package com.example.androidsamplecalculator

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun EmptyButton() {
    Button(onClick = { }) {
        Text(text = "")
    }
}