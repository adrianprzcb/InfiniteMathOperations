package com.adrian.infinitemathoperations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        
        BackButton(onClick = { navController.popBackStack() })
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
fun BackButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp), // 25% from left and right
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error // Set red color using MaterialTheme
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
