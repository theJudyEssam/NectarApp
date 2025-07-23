package com.example.nectar.ui.screens.HomeScreen

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
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.theme.GreenN


@Composable
fun HomeCategory(
    modifier: Modifier = Modifier,
    text:String= "Exclusive Offers"
){
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        CategoryTitle(text = text)
        CategoryItems()

    }
}

@Composable
fun CategoryTitle(
    modifier: Modifier = Modifier,
    text:String = "Exclusive Offers"
){
    Row(
        modifier = modifier.padding(vertical = 8.dp)
    ){
        Text(
            text,
            style = MaterialTheme.typography.displayMedium,
            modifier = modifier
                .weight(1f)
        )
        Text(
            "see all",
            color = GreenN
        )
    }
}

@Composable
fun CategoryItems(){

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp), // gap between items
        contentPadding = PaddingValues(horizontal = 16.dp),   // optional padding on both sides
        modifier = Modifier.fillMaxWidth()
    ) {
        items(10) { index ->
            ProductViewItem()
        }}
}
