package com.vocationalsubject.skillsubai.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vocationalsubject.skillsubai.authentication.LoginScreen
import com.vocationalsubject.skillsubai.authentication.SetupScreen
import com.vocationalsubject.skillsubai.authentication.SplashScreen
import com.vocationalsubject.skillsubai.chat.ChatScreen
import com.vocationalsubject.skillsubai.home.HomeScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Setup : Screen("setup")
    object Home : Screen("home")
    object Chat : Screen("chat")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Setup.route) {
            SetupScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Chat.route) {
            ChatScreen()
        }
    }
}
