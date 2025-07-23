package com.example.nectar.ui.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.Gilroy


@Composable
fun GroceriesRow(){

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ){
        CategoryTitle()

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // gap between items
            contentPadding = PaddingValues(horizontal = 16.dp),   // optional padding on both sides
            modifier = Modifier.fillMaxWidth()
        ) {
            items(10) { index ->
                GrocerieRowItem()
            }}

        CategoryItems()
    }



}

@Composable
fun GrocerieRowItem(
    color: Color = Color(0xFFF8A44C),
    text: String = "Grocery"
){
    Row(

        modifier = Modifier
            .background(color = color.copy(alpha = 0.3f), shape = RoundedCornerShape(17.dp))
            .width(248.19.dp)
            .height(105.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,

        ){
        Image(
            painter = painterResource(R.drawable.group__1_),
            contentDescription = null,
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
        )

        Text(text,
            fontSize = 20.sp,
            fontFamily = Gilroy,
            fontWeight = FontWeight.W600
        )
    }

}
