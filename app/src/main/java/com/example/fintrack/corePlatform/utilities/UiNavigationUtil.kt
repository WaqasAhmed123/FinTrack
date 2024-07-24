package com.example.fintrack.corePlatform.utilities

import LoadingState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.easyshop.view.tab_view.TabScreen
import com.example.fintrack.presentation.customViews.NoInternetConnection
import com.example.fintrack.presentation.addExpenses.AddExpensesView
import com.example.fintrack.presentation.analysis.AnalysisView
import com.example.fintrack.presentation.category.CategoryView
import com.example.fintrack.presentation.categoryDetail.CategoryDetailView
import com.example.fintrack.presentation.customViews.ErrorComposable
import com.example.fintrack.presentation.home.HomeView
import com.example.fintrack.presentation.login.LoginView
import com.example.fintrack.presentation.profile.ProfileView
import com.example.fintrack.presentation.signup.SignupView
import com.example.fintrack.presentation.splash.SplashView
import com.example.fintrack.presentation.tab.TabScreenViewModel
import com.example.fintrack.presentation.transaction.TransactionView

object UiNavigationUtil {

    @Composable
    fun App() {
//        var startView = "splash_screen"
        var startView = "login_screen"
//        var startView = "tab_screen"
//        var startView = "add_expenses_screen"
//        var startView = "profile_screen"
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
            composable (route = "tab_screen") {
                TabScreen(navController)
            }
            composable (route = "home_screen") {
                HomeView(navController)
            }
            composable (route = "analysis_screen") {
                AnalysisView(navController)
            }
            composable (route = "transaction_screen") {
                TransactionView(navController)
            }
            composable (route = "category_screen") {
                CategoryView(navController)
            }
            composable (route = "category_detail_screen/{category}") {
                CategoryDetailView(navController, it.arguments!!.getString("category", ""))
            }
            composable (route = "add_expenses_screen") {
                AddExpensesView(navController)
            }
            composable (route = "profile_screen") {
                ProfileView(navController)
            }
            composable (route = "network_error_screen") {
                ErrorComposable(onRetry = ({}))
            }
            composable (route = "no_internet_screen") {
                NoInternetConnection()
            }
            composable (route = "loading_screen") {
                LoadingState()
            }

        }
    }

    fun navigate(){

    }


}