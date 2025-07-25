package com.example.nectar.ui.screens.SearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.domain.model.product
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.components.SearchBar
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.GreyN
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.WhiteN


@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
){

   val products by viewModel.products.collectAsState()
    Scaffold(
        topBar = { SearchTopBar() }
    )
    {
        innerPadding ->
        SearchBody(products, modifier = Modifier.padding(8.dp),contentPadding = innerPadding)
    }
}


@Composable
fun SearchBody(
    products:List<product> = emptyList<product>(),
    modifier:Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues()
){

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp), // 👈 space between rows
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products){ product ->
            ProductViewItem(
                title = product.productName,
                image = product.productImg,
                details = product.productWeight,
                price = product.productPrice
            )
        }
    }
}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    onFiltersClick:()->Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            SearchBar()
        },
        actions =
            {
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
fun SearchScreenPreview(){
    NectarTheme {
        SearchTopBar() { }
    }
}