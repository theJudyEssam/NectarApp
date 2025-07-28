package com.example.nectar.ui.screens.ProductDetailsScreen.Sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.components.NumericCounter
import com.example.nectar.ui.theme.Gilroy

@Composable
fun ProductPriceSection(
    price: Float,
    quantity : Int = 0,
    onIncrement: (Int) -> Unit = {},
    onDecrement:(Int) -> Unit = {}

    ){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(16.dp)
    ){
        NumericCounter(
            modifier = Modifier,
            value = quantity,
            onIncrement = onIncrement,
            onDecrement = onDecrement
        )

        Spacer(
            Modifier.padding(horizontal = 90.dp)
        )


        Text(
            "$price$",
            style = TextStyle(
                fontFamily = Gilroy,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center
            ))
    }



}