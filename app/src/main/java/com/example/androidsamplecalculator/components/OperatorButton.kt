package com.example.androidsamplecalculator

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OperatorButton(modifier: Modifier, operator: Operator, onTap: (Operator) -> Unit) {
    Button(
        modifier = modifier.fillMaxHeight()
            .padding(all = 8.dp),
        onClick = { onTap(operator) }
    ) {
        Text(
            text = operator.symbol,
            fontSize = 50.sp
        )
    }
}