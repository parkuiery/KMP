package org.uiel.todos

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = "home",
        ) {
            composable(route = "home") {
                HomeScreen(
                    onNavigateDetail = { navController.navigate("detail") },
                    onNavigateWrite = { navController.navigate("write") }
                )
            }
            composable(route = "write") {
                WriteScreen(
                    onNavigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}