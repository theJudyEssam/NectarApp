package com.example.nectar.ui.screens.FiltersScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.Categories
import com.example.nectar.PriceFilters
import com.example.nectar.ui.components.FilterCheckbox
import com.example.nectar.ui.components.toggle
import com.example.nectar.ui.theme.Gilroy
import com.example.nectar.ui.theme.GreenN

@Composable
fun FiltersScreen(
    filtersViewModel: FiltersViewModel = hiltViewModel()
){

    val categoriesFilter = remember { mutableStateOf(setOf<String>()) }
    val pricesFilter = remember { mutableStateOf(setOf<String>()) }


    Scaffold(
        topBar = { FiltersNavBar() }
    ) {
        innerPadding -> FilterBody(
        modifier = Modifier.padding(innerPadding),
        filtersViewModel,
            categoriesFilter.value,
            pricesFilter.value,
            onCategoryChange = {category -> categoriesFilter.value = categoriesFilter.value.toggle(category)},
            onPriceChange = {category -> pricesFilter.value = pricesFilter.value.toggle(category)}
        )
    }

}


@Composable
fun FilterBody(
    modifier: Modifier = Modifier,
    filtersViewModel: FiltersViewModel,
    categoryFilter: Set<String>,
    priceFilters: Set<String>,
    onCategoryChange: (String) ->Unit,
    onPriceChange: (String)-> Unit
){

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFF2F3F2), shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .padding(horizontal = 16.dp),

        verticalArrangement = Arrangement.Center

    ){

        CategoriesSection(categoryFilter = categoryFilter, onCategoryChange = onCategoryChange)
        PricesSection(priceFilters = priceFilters, onPriceChange = onPriceChange)

        Button(
            onClick = {
                filtersViewModel.setFilterState(
                    FiltersState(
                    categoryFilter,
                    priceFilters)
                )
            },
            modifier = modifier
                .width(353.dp)
                .height(67.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenN
            )
        ) {
            Text("Apply Filter")
        }

    }
}

@Composable
fun CategoriesSection(
    modifier: Modifier = Modifier,
    categoryFilter: Set<String>,
    onCategoryChange: (String) -> Unit
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
            FilterCheckbox(categories.Name,
                categoryFilter.contains(categories.Name),
                onCategoryChange)
        }
    }
}

@Composable
fun PricesSection(
    priceFilters: Set<String>,
    onPriceChange: (String)->Unit
){

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
            FilterCheckbox(prices.Name,
                priceFilters.contains(prices.Name),
                onPriceChange)
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