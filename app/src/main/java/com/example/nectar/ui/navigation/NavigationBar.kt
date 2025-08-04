package com.example.nectar.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.nectar.R
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.GreyN

object NavigationBarConstants {

    val BottomNavItems = listOf(
        BottomNavItem(
            "Home",
            icon = R.drawable.vector,
            route = "home"
        ),
        BottomNavItem(
            "Explore",
            R.drawable.group_3,
            "explore"
        ),
        BottomNavItem(
            "Cart",
            R.drawable.vector__1_,
            "cart"
        )
    )
}


@Composable
fun BottomNavigationBar(navHostController: NavController){


    NavigationBar(
        containerColor =Color(0xFFFFFFFF)
    ) {
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
                        painter = painterResource(navItem.icon),
                        contentDescription = navItem.label
                    )
                },
                label ={
                    Text(navItem.label)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = GreenN,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = GreenN,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}