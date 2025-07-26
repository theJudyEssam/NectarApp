package com.example.nectar.ui.screens.HomeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.theme.GreenN


@Composable
fun HomeCategory(
    modifier: Modifier = Modifier,
    text:String= "Exclusive Offers",
    navController: NavController
){
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        CategoryTitle(text = text)
        CategoryItems(navController)

    }
}

@Composable
fun CategoryTitle(
    modifier: Modifier = Modifier,
    text:String = "Exclusive Offers"
){
    Row(
        modifier = modifier.padding(vertical = 16.dp)
    ){
        Text(
            text,
            style = MaterialTheme.typography.displayMedium,
            fontSize = 26.sp,
            modifier = modifier
                .weight(1f)
        )
    }
}

@Composable
fun CategoryItems(
    navController: NavController
){

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp), // gap between items
//        contentPadding = PaddingValues(horizontal = 8.dp),   // optional padding on both sides
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
    ) {
        items(10) { index ->
            ProductViewItem(
                modifier = Modifier.clickable(
                    onClick = { navController.navigate("product/${0}") } // for now i will put 0 while i set up product logic
                )
            )
        }}
}
