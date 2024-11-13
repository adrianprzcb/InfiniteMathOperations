package com.adrian.infinitemathoperations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    var showDifficultyButtons by remember { mutableStateOf(true) } // State variable to control button visibility
    var number1 by remember { mutableStateOf(0) } // Store first random number
    var number2 by remember { mutableStateOf(0) } // Store second random number
    var answer by remember { mutableStateOf(0) } // Store the sum
    var levelId by remember {
        mutableStateOf(0)
    }
    var userAnswer by remember { mutableStateOf("") } // Store user's entered answer
    var isAnswerCorrect by remember { mutableStateOf(false) } // Track if answer is correct

    fun generateAddition(maxValue: Int) {
        // Generate two random numbers within the specified range
        number1 = (1..maxValue).random()
        number2 = (1..maxValue).random()

        // Calculate the sum
        answer = number1 + number2
        isAnswerCorrect = false // Reset correctness flag for next problem
    }

    var backgroundColor by remember { mutableStateOf(Color.White) }
    // Background color state

    LaunchedEffect(isAnswerCorrect) { // Effect triggered on answer correctness change
        if (isAnswerCorrect) {
            backgroundColor = Color.Green // Set green for 0.5 seconds
            delay(500) // Delay for 0.5 seconds
            backgroundColor = Color.White // Reset background color

            var numMaxCalc = 0
            when (levelId) { // Use a more concise when expression
                1 -> numMaxCalc = 100
                2 -> numMaxCalc = 10000
                3 -> numMaxCalc = 1000000
                4 -> numMaxCalc = 10
            }

            generateAddition(numMaxCalc)
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        if (showDifficultyButtons) {

                Text("Select Difficulty", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(48.dp))  // Space between title and buttons

                DefaultButton("Very Easy", onClick = {
                showDifficultyButtons = false
                generateAddition(10)
                levelId = 4
                 })

                Spacer(modifier = Modifier.height(16.dp))  // Space between buttons
                DefaultButton("Easy", onClick = {
                    showDifficultyButtons = false
                    generateAddition(100)
                    levelId = 1
                })

                Spacer(modifier = Modifier.height(16.dp))  // Space between buttons
                DefaultButton("Medium", onClick = {
                    showDifficultyButtons = false
                    generateAddition(10000)
                    levelId = 2
                })

                Spacer(modifier = Modifier.height(16.dp))  // Space between buttons
                DefaultButton("Hard", onClick = {
                    showDifficultyButtons = false
                    generateAddition(1000000)
                    levelId = 3
                })

        } else {
            // Addition operation section (visible after easy button press)
            Text("What is ${number1} + ${number2} ?", style = MaterialTheme.typography.headlineMedium)
            OutlinedTextField(
                value = userAnswer,
                onValueChange = { userAnswer = it },
                label = { Text("Enter your answer") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // Set keyboard type to Number
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
            )
            LaunchedEffect(isAnswerCorrect) { // Update color on change
                backgroundColor = if (isAnswerCorrect) Color.Green else Color.White
            }

            Button(onClick = {
                val enteredAnswer = userAnswer.toIntOrNull()
                if (enteredAnswer != null) {
                    isAnswerCorrect = enteredAnswer == answer
                } else {
                    // Handle non-numeric input (e.g., show error message)
                }
            }) {
                Text(text = "Submit Answer")
            }

            // Add a button to regenerate the problem (optional)
            // ...
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Add BackButton at the bottom
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
