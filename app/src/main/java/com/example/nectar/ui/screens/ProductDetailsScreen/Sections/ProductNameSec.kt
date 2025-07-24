package com.example.nectar.ui.screens.ProductDetailsScreen.Sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.Gilroy
import java.nio.file.WatchEvent

@Composable
fun ProductNameSection(
     modifier: Modifier = Modifier,
     productName: String, productDetails:String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(16.dp)
    ) {

        Column(
            modifier = modifier.weight(1f)
        ){
            Text(productName,
                style = TextStyle(
                    fontFamily = Gilroy,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                ))
            Text(productDetails,
                style = MaterialTheme.typography.labelSmall)
        }

        IconButton(
            onClick = {} // no favourites so no implementation
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null
            )
        }

    }
}