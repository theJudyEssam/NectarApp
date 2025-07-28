package com.example.nectar.ui.screens.CategoryScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.theme.NectarTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nectar.domain.model.product
import com.example.nectar.ui.screens.MyCartScreen.CartViewModel


@Composable
fun CategoryScreen(
    categoryTitle: String,
    navController: NavController,
    categoryViewModel: CategoryScreenViewModel= hiltViewModel(),
    cartViewModel: CartViewModel = hiltViewModel()
){
    LaunchedEffect(categoryTitle) {
        categoryViewModel.getProductbyCategory(categoryTitle)
    }
    val products = categoryViewModel.products.collectAsState()
    val cartItemIds by cartViewModel.cartItemIds.collectAsState()

    Scaffold(
        topBar = { CategoryNavBar(categoryTitle = categoryTitle) }
    ) { innerPadding ->
        CategoryBody(modifier = Modifier.padding(horizontal = 8.dp),
            contentPadding = innerPadding,
            navController = navController,
            products = products.value,
            cartViewModel = cartViewModel,
            cartItemIds = cartItemIds
        )
    }
}


@Composable
fun CategoryBody(
    products: List<product>,
    navController: NavController,
    modifier:Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    cartViewModel: CartViewModel,
    cartItemIds: List<Int>
){


    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp), // 👈 space between rows
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products) { product ->
            ProductViewItem(
                title = product.productName,
                image = product.productImg,
                price = product.productPrice,
                details = product.productWeight,
                modifier = modifier.clickable(
                    onClick = {navController.navigate("product/${product.Id}")}
                ),
                addCart = {cartViewModel.ToggleCartItem(product)},
                isInCart = cartItemIds.contains(product.Id)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryNavBar(
    categoryTitle:String = "Category",
    onBackClick:()->Unit = {},
    onFiltersClick:()-> Unit = {}
){

    CenterAlignedTopAppBar(
        title = {
            Text(categoryTitle, style = MaterialTheme.typography.titleMedium)
        } ,
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        actions =  {
            IconButton(onClick = onFiltersClick) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Filter",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }

    )
}


@Preview(showBackground = true)
@Composable
fun CategoryPreview(){
    NectarTheme {
    }
}