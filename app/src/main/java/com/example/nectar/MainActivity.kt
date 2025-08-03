package com.example.nectar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat.startActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.ui.navigation.AppNavigation
import com.example.nectar.ui.navigation.BottomNavigationBar
import com.example.nectar.ui.navigation.MainContainer
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.NectarTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay


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
                    AppNavigation(navController)
                }
            }
        }
    }
}



@Composable
fun SplashScreen(navController: NavHostController){

    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds
        navController.navigate("onboarding") {
            popUpTo("splash") { inclusive = true }
        }
    }


    Box(
        modifier = Modifier.fillMaxSize().background(GreenN),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.nectar_logo),
            contentDescription = null
        )
    }
}
