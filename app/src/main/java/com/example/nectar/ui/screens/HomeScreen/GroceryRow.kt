package com.example.nectar.ui.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import com.example.nectar.Categories
import com.example.nectar.R
import com.example.nectar.domain.model.product
import com.example.nectar.ui.theme.Gilroy


@Composable
fun GroceriesRow(
    navController: NavController,
    title:String = "title",
    products: List<product>
){

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ){
        CategoryTitle(text = title)

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // gap between items
            modifier = Modifier.fillMaxWidth()
        ) {
            items(Categories.entries) { category ->
                GrocerieRowItem(text = category.Name,
                    color = category.Color,
                    onClick = {navController.navigate("categories/${category.Name}")})
            }}

        CategoryItems(navController, products)
    }



}

@Composable
fun GrocerieRowItem(
    color: Color = Color(0xFFF8A44C),
    text: String = "Grocery",
    onClick: () -> Unit
){
    Row(

        modifier = Modifier
            .background(color = color.copy(alpha = 0.3f), shape = RoundedCornerShape(17.dp))
            .width(248.19.dp)
            .height(105.dp)
            .clickable(onClick = onClick)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

        ){
        Image(
            painter = painterResource(R.drawable.group__1_),
            contentDescription = null,
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .padding(4.dp)
        )

        Text(text,
            fontSize = 18.sp,
            fontFamily = Gilroy,
            fontWeight = FontWeight.W600
        )
    }

}
