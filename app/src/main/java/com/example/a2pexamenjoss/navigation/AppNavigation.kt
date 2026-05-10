package com.example.a2pexamenjoss.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a2pexamenjoss.screens.DetailScreen
import com.example.a2pexamenjoss.screens.HomeScreen

object Routes {

    const val HOME_SCREEN = "Home"
    const val DETAIL_SCREEN = "detail/{characterId}"
}

@Composable
fun AppNavigation(title: String) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {

        composable(route = "Home") {
            HomeScreen(
                title = title,
                navController = navController
            )
        }
        composable(
            route = "detail/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getInt("characterId") ?: 0

            DetailScreen(
                title = title,
                navController = navController,
                characterId = characterId
            )
        }
    }
}

