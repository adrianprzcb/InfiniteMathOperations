package com.adrian.infinitemathoperations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adrian.infinitemathoperations.ui.AddScreen
import com.adrian.infinitemathoperations.ui.theme.InfiniteMathOperationsTheme
import kotlinx.coroutines.delay

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
                    SubtractScreen(navController)
                }
                composable(Screen.MultiplyScreen.route) {
                    MultiplyScreen(navController)
                }
                composable(Screen.DivideScreen.route) {
                    DivideScreen(navController)
                }
                composable(Screen.RandomScreen.route) {
                    RandomScreen(navController)
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
            .background(Color(0xFFAFFCD8))
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







        ///  SUBTRACT SCREEN ªªª!!!!!!
@Composable
fun SubtractScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // This is the default
    ) {
        Text("Select Difficulty", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(48.dp))  // Space between title and buttons

        DefaultButton("Easy", onClick = {
            // ...
        })

        Spacer(modifier = Modifier.height(16.dp))  // Space between buttons
        DefaultButton("Medium", onClick = {
            // ...
        })

        Spacer(modifier = Modifier.height(16.dp))  // Space between buttons
        DefaultButton("Hard", onClick = {
            // ...
        })

        Spacer(modifier = Modifier.height(16.dp))
        // Add BackButton at the bottom
        BackButton(onClick = { navController.popBackStack() })
    }
}

///  MULTYPLY SCREEN ªªª!!!!!!
@Composable
fun MultiplyScreen(navController: NavHostController) {
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

        Spacer(modifier = Modifier.height(16.dp))
        // Add BackButton at the bottom
        BackButton(onClick = { navController.popBackStack() })
    }

}


///  DIVIDE SCREEN ªªª!!!!!!
@Composable
fun DivideScreen(navController: NavHostController) {
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

        Spacer(modifier = Modifier.height(16.dp))
        // Add BackButton at the bottom
        BackButton(onClick = { navController.popBackStack() })
    }
}


///  RANDOM SCREEN ªªª!!!!!!
@Composable
fun RandomScreen(navController: NavHostController) {
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

        Spacer(modifier = Modifier.height(16.dp))
        // Add BackButton at the bottom
        BackButton(onClick = { navController.popBackStack() })
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


@Composable
fun BackButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp , vertical = 10.dp), // 25% from left and right
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFEF5541) // Set red color using MaterialTheme
        ),
        contentPadding = PaddingValues(16.dp), // Add some content padding
    ) {
        Text(text = "Back") // Text color is inherited from the Button style
    }
}


@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
    InfiniteMathOperationsTheme {
        MainMenu(navController = rememberNavController())
    }
}
