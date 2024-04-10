package com.adrian.infinitemathoperations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adrian.infinitemathoperations.ui.theme.InfiniteMathOperationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()



            NavHost(navController, startDestination = Screen.MainMenu.route) {
                composable(Screen.MainMenu.route) {
                    MainMenu(navController)
                }
                composable(Screen.AddScreen.route) {
                    AddScreen(navController)
                }
                composable(Screen.SubtractScreen.route) {
                    // Aquí puedes llamar a la pantalla de resta
                }
                composable(Screen.MultiplyScreen.route) {
                    // Aquí puedes llamar a la pantalla de multiplicación
                }
                composable(Screen.DivideScreen.route) {
                    // Aquí puedes llamar a la pantalla de división
                }
                composable(Screen.RandomScreen.route) {
                    // Aquí puedes llamar a la pantalla de aleatorio
                }
            }
        }
    }
}

@Composable
fun MainMenu(navController: NavHostController) {
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
        DefaultButton(text = "Add") {
            navController.navigate(Screen.AddScreen.route)
        }
        Spacer(modifier = Modifier.height(16.dp))
        DefaultButton(text = "Subtract") {
            navController.navigate(Screen.SubtractScreen.route)
        }
        Spacer(modifier = Modifier.height(16.dp))
        DefaultButton(text = "Multiply") {
            navController.navigate(Screen.MultiplyScreen.route)
        }
        Spacer(modifier = Modifier.height(16.dp))
        DefaultButton(text = "Divide") {
            navController.navigate(Screen.DivideScreen.route)
        }
        Spacer(modifier = Modifier.height(16.dp))
        DefaultButton(text = "Random") {
            navController.navigate(Screen.RandomScreen.route)
        }
    }
}


///  ADD SCREEN ªªª!!!!!!
@Composable
fun AddScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Select Difficulty", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(48.dp))  // To provide some spacing between the title and the buttons

        DefaultButton("Easy", onClick = {
            // Navigate or handle easy difficulty logic
        })

        Spacer(modifier = Modifier.height(16.dp))  // Space between buttons
        DefaultButton("Medium", onClick = {
            // Navigate or handle medium difficulty logic
        })

        Spacer(modifier = Modifier.height(16.dp))
        DefaultButton("Hard", onClick = {
            // Navigate or handle hard difficulty logic
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultButton(text: String, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
    InfiniteMathOperationsTheme {
        MainMenu(navController = rememberNavController())
    }
}
