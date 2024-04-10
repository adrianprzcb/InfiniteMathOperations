package com.adrian.infinitemathoperations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrian.infinitemathoperations.ui.theme.InfiniteMathOperationsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfiniteMathOperationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainMenu()
                }
            }
        }
    }
}

@Composable
fun MainMenu() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Infinite Math Operations",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        OptionButton(text = "Add", onClick = {})
        Spacer(modifier = Modifier.height(16.dp))
        OptionButton(text = "Subtract", onClick = {})
        Spacer(modifier = Modifier.height(16.dp))
        OptionButton(text = "Multiply", onClick = {})
        Spacer(modifier = Modifier.height(16.dp))
        OptionButton(text = "Divide", onClick = {})
        Spacer(modifier = Modifier.height(16.dp))
        OptionButton(text = "Random", onClick = {})
    }
}

@Composable
fun OptionButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
    InfiniteMathOperationsTheme {
        MainMenu()
    }
}
