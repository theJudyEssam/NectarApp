package com.example.nectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.screens.CategoryScreen.CategoryScreen
import com.example.nectar.ui.screens.ExploreScreen.ExploreScreen
import com.example.nectar.ui.screens.HomeScreen.HomeScreen
import com.example.nectar.ui.screens.ProductDetailsScreen.ProductDetailsScreen
import com.example.nectar.ui.screens.SearchScreen.SearchScreen
import com.example.nectar.ui.theme.NectarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {

        }
        enableEdgeToEdge()
        setContent {
            NectarTheme {
                ProductDetailsScreen(modifier = Modifier.padding(top = 100.dp))
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NectarTheme {
        Greeting("Android")
    }
}