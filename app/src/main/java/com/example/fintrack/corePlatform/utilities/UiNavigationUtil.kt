package com.example.fintrack.corePlatform.utilities

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fintrack.presentation.login.LoginView
import com.example.fintrack.presentation.signup.SignupView
import com.example.fintrack.presentation.splash.SplashView

object UiNavigationUtil {

    @Composable
    fun App() {
        var startView = "signup_screen"
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = startView) {
            composable(route = "splash_screen") {
                SplashView(navControllerP = navController)
            }
            composable(route = "login_screen") {
                LoginView(navController)
            }
            composable (route = "signup_screen") {
                SignupView(navController)
            }

        }
    }

    fun navigate(){

    }


}