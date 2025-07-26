package com.example.nectar.ui.screens.ExploreScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nectar.Categories
import com.example.nectar.R
import com.example.nectar.ui.components.ProductViewItem
import com.example.nectar.ui.components.SearchBar
import com.example.nectar.ui.theme.Gilroy


@Composable
fun ExploreScreen(){
    Scaffold(
        topBar = {ExploreTopBar()}
    ) {
        innerPadding ->
        ExploreBody( modifier = Modifier.padding(16.dp),contentPadding = innerPadding)
    }
}


@Composable
fun ExploreBody(
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
        items(Categories.entries){ category ->
            ExploreItem(Category = category.Name, color = category.Color)
        }
    }
}



@Composable
fun ExploreTopBar(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            "Find Products",
            style = TextStyle(
                fontWeight = FontWeight.W600,
                fontFamily = Gilroy,
                fontSize = 20.sp,
                lineHeight = 18.sp
            ), 
            modifier = modifier.padding(8.dp)
        )
        SearchBar()
    }
}

@Composable
fun ExploreItem(
    modifier: Modifier = Modifier,
    imageSrc: String = "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png](https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png",
    Category: String = "Food&Food",
    color: Color = Color.Red
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(color = color.copy(alpha = 0.3f), shape = RoundedCornerShape(18.dp))
            .width(174.5.dp)
            .height(189.11.dp)
            .padding(8.dp)

    ){
        Image(
            painter = rememberAsyncImagePainter(imageSrc),
            contentDescription = "$Category",
            modifier = modifier
                .width(110.dp)
                .height(80.dp)
        )

        Text(
            text = "$Category",
            style = MaterialTheme.typography.labelMedium,
            modifier = modifier.padding(vertical = 8.dp)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun ExplorePreview(){
    ExploreScreen()
//    ExploreItem()
}