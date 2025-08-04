package com.example.nectar.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nectar.SplashScreen
import com.example.nectar.ui.screens.CategoryScreen.CategoryScreen
import com.example.nectar.ui.screens.ExploreScreen.ExploreScreen
import com.example.nectar.ui.screens.HomeScreen.HomeScreen
import com.example.nectar.ui.screens.MyCartScreen.CartsScreen
import com.example.nectar.ui.screens.OnboardingScreen.OnBoardingScreen
import com.example.nectar.ui.screens.OrderAcceptedScreen.OrderAcceptedScreen
import com.example.nectar.ui.screens.ProductDetailsScreen.ProductDetailsScreen
import com.example.nectar.ui.screens.SearchScreen.SearchScreen

@Composable
fun AppNavigation(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = "splash"
    ){
        composable("splash"){
            SplashScreen(navController)
        }

        composable("onboarding"){
            OnBoardingScreen(
                onClick = {navController.navigate("main")}
            )
        }

        composable("main"){
            MainContainer(parentNavController = navController)
        }

        // Move order_accepted here so it's outside the MainContainer (no bottom bar)
        composable("order_accepted"){
            OrderAcceptedScreen(navController)
        }
    }
}

@Composable
fun MainContainer(
    parentNavController: NavHostController // Pass the parent nav controller
){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ){
            innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding),
        )
        {
            composable("home") {
                HomeScreen(navController = navController)
            }

            composable("explore") {
                ExploreScreen(navController = navController)
            }

            composable("cart") {
                // Pass the parent nav controller to navigate to order_accepted
                CartsScreen(navController = navController,parentNavController = parentNavController)
            }

            composable(
                route = "categories/{category}",
                arguments = listOf(navArgument("category"){type = NavType.StringType})
            ){
                val category = it.arguments?.getString("category")?:""
                CategoryScreen(category, navController, navigateBack = {navController.navigateUp()})
            }

            composable(
                route = "product/{productId}",
                arguments = listOf(navArgument("productId"){
                    type = NavType.IntType
                }))
            {
                val productId = it.arguments?.getInt("productId")?:0
                ProductDetailsScreen(productId = productId, onBackClick = {navController.navigateUp()})
            }

            composable("search") {
                SearchScreen(navController)
            }
        }
    }
}