package com.example.nectar.ui.navigation

import android.R.attr.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.nectar.ui.screens.CategoryScreen.CategoryScreen
import com.example.nectar.ui.screens.ExploreScreen.ExploreScreen
import com.example.nectar.ui.screens.HomeScreen.HomeScreen
import com.example.nectar.ui.screens.MyCartScreen.CartsScreen
import com.example.nectar.ui.screens.OnboardingScreen.OnBoardingScreen
import com.example.nectar.ui.screens.ProductDetailsScreen.ProductDetailsScreen
import com.example.nectar.ui.screens.SearchScreen.SearchScreen

@Composable

fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
){

    NavHost(
        navController = navController,

        startDestination = "home",

        modifier = Modifier.padding(paddingValues = padding),
    )
    {

        composable("onboarding"){
            OnBoardingScreen(onClick = {navController.navigate("home")})
        }

        composable("home") {
            HomeScreen(navController =  navController)
        }

        // route : search
        composable("explore") {
            ExploreScreen(navController = navController)
        }

        // route : cart
        composable("cart") {
            CartsScreen(navController = navController)
        }

        //route : categories
        composable(
            route = "categories/{category}",
            arguments = listOf(navArgument("category"){type = NavType.StringType})
        ){
            val category = it.arguments?.getString("category")?:""
            CategoryScreen(category, navController)
        }

        composable(
            route = "product/{productId}",
            arguments = listOf(navArgument("productId"){
                type = NavType.IntType
            }))
        {
            val productId = it.arguments?.getInt("productId")?:0
            ProductDetailsScreen(productId = productId)

        }

    }
}