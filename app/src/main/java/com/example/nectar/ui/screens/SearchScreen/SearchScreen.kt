package com.example.nectar.ui.screens.SearchScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nectar.domain.model.product
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.components.SearchBar
import com.example.nectar.ui.screens.FiltersScreen.FiltersScreen
import com.example.nectar.ui.theme.NectarTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
){

    val products by viewModel.products.collectAsState()
    var showFilters by remember {mutableStateOf(false)}
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    var query by remember {mutableStateOf("")}




    Scaffold(
        topBar = { SearchTopBar(
            navController,
            onFiltersClick = {
                coroutineScope.launch { showFilters = true }
            },
            query = query,
            onQueryChange = {
                query = it
                viewModel.Search(query)
            }
            )}
    )
    {
        innerPadding ->
        SearchBody(navController, products,
            modifier = Modifier.padding(8.dp),
            contentPadding = innerPadding)


        if (showFilters){
            ModalBottomSheet(
            onDismissRequest = { showFilters = false},
                sheetState = sheetState,
                modifier = Modifier.fillMaxHeight()
            ) {
                FiltersScreen()
            }
        }


    }
}


@Composable
fun SearchBody(
    navController: NavController,
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
                price = product.productPrice,
                modifier = Modifier.clickable(
                    onClick = { navController.navigate("product/${product.Id}") }
                )
            )
        }
    }
}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    navController: NavController,
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    onFiltersClick:()->Unit = {}
) {

    CenterAlignedTopAppBar(
        title = {
            SearchBar(
                navController,
                query,
                onQueryChange)
        },
        actions =
            {
                IconButton(onClick = { onFiltersClick() }) {
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

    }
}