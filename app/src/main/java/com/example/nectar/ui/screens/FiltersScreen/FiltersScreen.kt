package com.example.nectar.ui.screens.FiltersScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.Categories
import com.example.nectar.PriceFilters
import com.example.nectar.ui.components.FilterCheckbox
import com.example.nectar.ui.theme.Gilroy
import com.example.nectar.ui.theme.GreenN

@Composable
fun FiltersScreen(){
    Scaffold(
        topBar = { FiltersNavBar() }
    ) {
        innerPadding -> FilterBody(modifier = Modifier.padding(innerPadding))
    }

}


@Composable
fun FilterBody(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF2F3F2), shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .padding(horizontal = 16.dp), 

        verticalArrangement = Arrangement.Center

    ){

        CategoriesSection()
        PricesSection()

        Button(
            onClick = {},
            modifier = modifier
                .width(353.dp)
                .height(67.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenN // or any other Color
            )
        ) {
            Text("Apply Filter")
        }

    }
}

@Composable
fun CategoriesSection(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.padding(vertical = 16.dp)
    ){
        Text("Categories",
            style=  TextStyle(
                fontFamily = Gilroy,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 100.sp
            )
        )
        for (categories in Categories.entries) {
            FilterCheckbox(categories.Name)
        }
    }
}

@Composable
fun PricesSection(){

    Column(){
        Text("Price Range",
            style=  TextStyle(
                fontFamily = Gilroy,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 100.sp
            )
        )
        for (prices in PriceFilters.entries) {
            FilterCheckbox(prices.Name)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersNavBar(
    onBackClick:() -> Unit = {}
){
    CenterAlignedTopAppBar(
        title = {
            Text("Filters",
                 style = MaterialTheme.typography.titleMedium)
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun FilterScreenPreview(){
    FiltersScreen()
}