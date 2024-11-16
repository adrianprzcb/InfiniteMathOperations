package com.adrian.infinitemathoperations.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adrian.infinitemathoperations.BackButton
import com.adrian.infinitemathoperations.DefaultButton
import kotlinx.coroutines.delay

///  ADD SCREEN ªªª!!!!!!
@OptIn(ExperimentalMaterial3Api::class)
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

    var backgroundColor by remember { mutableStateOf(Color(0xFFAFFCD8)) }
    var inarow by remember { mutableStateOf(0) }
    // Background color state

    LaunchedEffect(isAnswerCorrect) { // Effect triggered on answer correctness change
        if (isAnswerCorrect) {
            delay(200) // Delay for 0.5 seconds

            var numMaxCalc = 0
            when (levelId) { // Use a more concise when expression
                1 -> numMaxCalc = 100
                2 -> numMaxCalc = 10000
                3 -> numMaxCalc = 1000000
                4 -> numMaxCalc = 10
            }

            userAnswer = ""
            inarow += 1
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .background(backgroundColor),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween, // Space out elements
            ) {
                // "In a Row" counter at the top
                Text(
                    text = "In a Row: $inarow",
                    style = MaterialTheme.typography.bodyMedium, // Smaller text
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.Start) // Align to top-left
                        .padding(horizontal = 16.dp)
                )

                // Centered addition problem and input field
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight(0.8f) // Take up 80% of vertical space
                ) {
                    Text(
                        text = "What is ${number1} + ${number2}?",
                        style = MaterialTheme.typography.displayMedium, // Larger text
                        modifier = Modifier.padding(bottom = 32.dp)
                    )

                    OutlinedTextField(
                        value = userAnswer,
                        onValueChange = { userAnswer = it },
                        label = { Text("Enter your answer") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp)
                            .clip(RoundedCornerShape(16.dp)) // Rounded corners
                            .background(Color.White)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            val enteredAnswer = userAnswer.toIntOrNull()
                            if (enteredAnswer != null) {
                                isAnswerCorrect = enteredAnswer == answer
                            } else {
                                // Handle invalid input
                            }
                        },
                        modifier = Modifier.padding(horizontal = 32.dp)
                    ) {
                        Text(text = "Submit Answer")
                    }
                }

                // Back button at the bottom
                BackButton(
                    onClick = { navController.popBackStack() }
                )
            }

            // Update background color based on answer correctness
            LaunchedEffect(isAnswerCorrect) {
                backgroundColor = if (isAnswerCorrect) Color(0xFF3FFFA6) else Color(0xFFAFFCD8)
            }
        }
    }
}

