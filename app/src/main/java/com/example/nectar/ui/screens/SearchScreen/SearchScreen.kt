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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.nectar.PriceFilters
import com.example.nectar.R
import com.example.nectar.domain.model.product
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.components.SearchBar
import com.example.nectar.ui.screens.FiltersScreen.FiltersScreen
import com.example.nectar.ui.screens.FiltersScreen.FiltersViewModel
import com.example.nectar.ui.screens.MyCartScreen.CartViewModel
import com.example.nectar.ui.theme.NectarTheme
import kotlinx.coroutines.launch
import kotlin.contracts.contract


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = hiltViewModel(),
    filtersViewModel: FiltersViewModel = hiltViewModel(),
    CartViewModel: CartViewModel = hiltViewModel(),
    ){


    val products by searchViewModel.products.collectAsState() // all products
    val filterState by filtersViewModel.filterState.collectAsState() // filter options that user chose

    // to trigger filter screen visibility
    var showFilters by remember {mutableStateOf(false)}
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()

    var query by remember {mutableStateOf("")}



    // "Search Logic"
    var filteredProducts = products.filter { product ->
        val categoryMatch = filterState.selectedCategories.isEmpty() || filterState.selectedCategories.contains(product.productCategory)
        product.productName.contains(query, ignoreCase = true) && categoryMatch
    }

    if(filterState.selectedPrices.contains(PriceFilters.HIGHEST.Name)  // "the choice of this bad-practiced if statement 💀💀"
        && filterState.selectedPrices.contains(PriceFilters.LOWEST.Name)){ // if the user chose both
        // do nothing
    }
    else if(filterState.selectedPrices.contains(PriceFilters.HIGHEST.Name)){
        filteredProducts =  filteredProducts.sortedByDescending { it.productPrice }
    }
    else if (filterState.selectedPrices.contains(PriceFilters.LOWEST.Name)){
        filteredProducts = filteredProducts.sortedBy{ it.productPrice }
    }


    Scaffold(
        topBar = { SearchTopBar(
            navController,
            onFiltersClick = {
                coroutineScope.launch { showFilters = true }
            },
            query = query,
            onQueryChange = {
                query = it
            },
            emptyQuery = {
                query = ""
            }
            )}
    )
    {
        innerPadding ->
        SearchBody(navController, filteredProducts,
            modifier = Modifier.padding(8.dp),
            contentPadding = innerPadding,
            cartViewModel = CartViewModel)


        if (showFilters){
            ModalBottomSheet(
            onDismissRequest = { showFilters = false},
                sheetState = sheetState,
                modifier = Modifier.fillMaxHeight()
            ) {
                FiltersScreen(navigateBack = {navController.navigate("search")})
            }
        }


    }
}


@Composable
fun SearchBody(
    navController: NavController,
    products:List<product> = emptyList<product>(),
    modifier:Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    cartViewModel: CartViewModel
){

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp), // 👈 space between rows
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products){ product ->

            LaunchedEffect(product.Id) {
                cartViewModel.fetchCartItem(product.Id)
            }

            val cartItemIds by cartViewModel.cartItemIds.collectAsState()


            ProductViewItem(
                title = product.productName,
                image = product.productImg,
                details = product.productWeight,
                price = product.productPrice,
                modifier = Modifier.clickable(
                    onClick = { navController.navigate("product/${product.Id}") }
                ),
                addCart = {cartViewModel.ToggleCartItem(product)},
                isInCart =  cartItemIds.contains(product.Id)

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
    onFiltersClick:()->Unit = {},
    emptyQuery : () -> Unit
) {

    CenterAlignedTopAppBar(
        title = {
            SearchBar(
                navController,
                query,
                onQueryChange,
                emptyQuery)
        },
        actions =
            {
                IconButton(onClick = { onFiltersClick() }) {
                    Icon(
                        painter = painterResource(R.drawable.filter),
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