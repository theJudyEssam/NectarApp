package com.example.nectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.nectar.ui.navigation.BottomNavigationBar
import com.example.nectar.ui.navigation.NavHostContainer
import com.example.nectar.ui.screens.MyCartScreen.CartsScreen
import com.example.nectar.ui.screens.SearchScreen.SearchScreen
import com.example.nectar.ui.theme.NectarTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {

        }
        enableEdgeToEdge()
        setContent {
            NectarTheme {
                val navController = rememberNavController()
                Surface(color = Color.White){

                    Scaffold(
                        bottomBar = { BottomNavigationBar(navController) }
                    ) {
                        padding ->
                        NavHostContainer(
                            navController =navController,
                            padding = padding
                        )
                    }
                }
            }
        }
    }
}
