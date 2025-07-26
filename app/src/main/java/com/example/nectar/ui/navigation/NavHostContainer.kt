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
import com.example.nectar.ui.screens.SearchScreen.SearchScreen

@Composable

fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
){

    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "home",

        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),



    )
    {
        composable("home") {
            HomeScreen()
        }

        // route : search
        composable("explore") {
            ExploreScreen()
        }

        // route : cart
        composable("cart") {
            CartsScreen()
        }

        //route : categories
        composable(
            route = "categories/:category",
            arguments = listOf(navArgument("category"){type = NavType.StringType})
        ){
            //  val itemId = it.arguments?.getInt("itemId")?: -1

            val category = it.arguments?.getString("category")?:""
            CategoryScreen()
        }

    }
}