package com.example.androidsamplecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.*
import androidx.compose.ui.*
import androidx.compose.runtime.Composable
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
                    Column() {
                        ButtonRow(
                            "7", "8","9","*",
                        )
                        ButtonRow(
                            "4", "5","6","-",
                        )
                        ButtonRow(
                            "1", "2","3","+",
                        )
                        ButtonRow(
                            "0", ".","x","=",
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonRow(first: String, second: String, third: String, fourth: String) {
    Row () {
        Button(onClick = { /*TODO*/ }) {
            Text(text = first)
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = second)
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = third)
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = fourth)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidSampleCalculatorTheme {
        Column() {
            ButtonRow(
                "7", "8","9","*",
            )
            ButtonRow(
                "4", "5","6","-",
            )
            ButtonRow(
                "1", "2","3","+",
            )
            ButtonRow(
                "0", ".","x","=",
            )
        }
    }
}