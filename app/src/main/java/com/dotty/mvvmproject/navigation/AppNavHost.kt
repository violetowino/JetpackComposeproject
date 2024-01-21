package com.dotty.mvvmproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dotty.mvvmproject.ui.theme.screens.about.AboutUsScreen
import com.dotty.mvvmproject.ui.theme.screens.bookspace.BookSpaceScreen
import com.dotty.mvvmproject.ui.theme.screens.bookspace.ConfirmBookingScreen
import com.dotty.mvvmproject.ui.theme.screens.contact.ContactUsScreen
import com.dotty.mvvmproject.ui.theme.screens.customlistview.CustomListScreen
import com.dotty.mvvmproject.ui.theme.screens.dashboard.DashboardScreen
import com.dotty.mvvmproject.ui.theme.screens.home.HomeScreen
import com.dotty.mvvmproject.ui.theme.screens.login.LoginScreen
import com.dotty.mvvmproject.ui.theme.screens.register.RegisterScreen
import com.dotty.mvvmproject.ui.theme.screens.resetpassword.ResetPassword
import com.dotty.mvvmproject.ui.theme.screens.services.ServiceScreen
import com.dotty.mvvmproject.ui.theme.screens.splash.SplashScreen


@Composable
fun AppNavHost(
    modifier: Modifier=Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH
) {
    NavHost(
        navController = navController,
        modifier = Modifier,
        startDestination = startDestination ){

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_CUSTOMLISTVIEW) {
            CustomListScreen(navController)
        }
        composable(ROUTE_RESETPASSWORD) {
            ResetPassword(navController)
        }
        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUTE_ABOUT) {
            AboutUsScreen(navController)
        }
        composable(ROUTE_BOOKSPACE) {
            BookSpaceScreen(navController)
        }
        composable(ROUTE_CONTACTUS) {
            ContactUsScreen(navController)
        }
        composable(ROUTE_SERVICES) {
            ServiceScreen(navController)
        }
        composable(ROUTE_CONFIRM) { backStackEntry ->
            // Retrieve the arguments passed from the BookSpaceScreen
            val selectedDate = backStackEntry.arguments?.getString("selectedDate") ?: ""
            val selectedTimeIn = backStackEntry.arguments?.getString("selectedTimeIn") ?: ""
            val selectedTimeOut = backStackEntry.arguments?.getString("selectedTimeOut") ?: ""
            val selectedSpaceIndex =
                backStackEntry.arguments?.getInt("selectedSpaceIndex") ?: -1

            // Call the ConfirmationPage composable with the selected details
            ConfirmBookingScreen(
                selectedDate = selectedDate,
                selectedTimeIn = selectedTimeIn,
                selectedTimeOut = selectedTimeOut,
                selectedSpaceIndex = selectedSpaceIndex,
                navController = navController
            )
        }
    }

}