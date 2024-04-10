package com.adrian.infinitemathoperations

sealed class Screen(val route: String) {
    object MainMenu : Screen("main_menu")
    object AddScreen : Screen("add_screen")
    object SubtractScreen : Screen("subtract_screen")
    object MultiplyScreen : Screen("multiply_screen")
    object DivideScreen : Screen("divide_screen")
    object RandomScreen : Screen("random_screen")
}
