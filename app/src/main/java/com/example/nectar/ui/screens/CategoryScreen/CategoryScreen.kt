package com.example.nectar.ui.screens.CategoryScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.components.PhotoCard
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.theme.NectarTheme
import androidx.compose.foundation.layout.statusBarsPadding


@Composable
fun CategoryScreen(
    categoryTitle: String
){
    Scaffold(
        topBar = { CategoryNavBar(categoryTitle = categoryTitle) }
    ) { innerPadding ->
        CategoryBody(modifier = Modifier.padding(horizontal = 8.dp),contentPadding = innerPadding)
    }
}


@Composable
fun CategoryBody(
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
        items(10){
            ProductViewItem()
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
        CategoryScreen("Category")
    }
}