package com.example.nectar.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

object NavigationBarConstants {

    val BottomNavItems = listOf(
        BottomNavItem(
            "Home",
            icon = Icons.Default.Home,
            route = "home"
        ),
        BottomNavItem(
            "Explore",
            Icons.Default.Search,
            "explore"
        ),
        BottomNavItem(
            "Cart",
            Icons.Default.ShoppingCart,
            "cart"
        )
    )
}


@Composable
fun BottomNavigationBar(navHostController: NavHostController){


    NavigationBar {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        NavigationBarConstants.BottomNavItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navHostController.navigate(navItem.route)
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.label
                    )
                },
                label ={
                    Text(navItem.label)
                }
            )
        }


    }
}