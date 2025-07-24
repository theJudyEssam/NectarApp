package com.example.nectar.ui.screens.ProductDetailsScreen.Sections

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailsSections(
    modifier: Modifier = Modifier,
    productDescription: String
){
    var details_visible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.padding(16.dp)
    ){

        Row(){
            Text(
                "Product Details",
                style = MaterialTheme.typography.labelMedium,
                modifier = modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Arrow Down",
                modifier = modifier.clickable(
                    enabled = true, onClick = {
                        details_visible = !details_visible

                    }
                )
            )
        }

        AnimatedVisibility(
            details_visible == true
        ) {
            Text(
                productDescription,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Left
            )
        }

    }

}