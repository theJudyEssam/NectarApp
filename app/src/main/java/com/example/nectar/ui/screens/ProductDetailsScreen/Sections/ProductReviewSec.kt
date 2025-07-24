package com.example.nectar.ui.screens.ProductDetailsScreen.Sections

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductReviewSection(
    modifier: Modifier = Modifier,
    rating: Int
){
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            "Rating",
            style = MaterialTheme.typography.labelMedium,
            modifier = modifier.weight(1f)
        )


        for(i in 0..rating){
            Icon(
                imageVector = Icons.Default.Star,
                tint = Color.Red,
                contentDescription = null
            )
        }
    }
}