package com.example.composenoteapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenoteapp.ui.home.HomeScreen

@Composable
fun MainNavigation() {
    val controller = rememberNavController()
    NavHost(navController = controller, startDestination = MainRoutes.HomeScreen.name ) {
        composable(route = MainRoutes.HomeScreen.name) {
            HomeScreen()
        }
    }
}