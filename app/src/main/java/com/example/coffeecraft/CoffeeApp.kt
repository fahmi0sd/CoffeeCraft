package com.example.coffeecraft

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coffeecraft.ui.theme.DetailScreen
import com.example.coffeecraft.ui.theme.HomeScreen

@Composable
fun CoffeeApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable(route = "home") {
            HomeScreen(
                navigateToDetail = { coffeeId ->
                    navController.navigate("detail/$coffeeId")
                }
            )
        }

        composable(
            route = "detail/{coffeeId}",
            arguments = listOf(
                navArgument("coffeeId") { type = NavType.LongType }
            )
        ) { backStackEntry ->
            // Ambil ID dari argumen navigasi
            val coffeeId = backStackEntry.arguments?.getLong("coffeeId") ?: 0L

            // Tampilkan DetailScreen
            DetailScreen(coffeeId = coffeeId)
        }
    }
}