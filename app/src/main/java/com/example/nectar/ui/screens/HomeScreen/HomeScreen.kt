package com.example.nectar.ui.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.nectar.R
import com.example.nectar.ui.components.FakeSearchBar
import com.example.nectar.ui.screens.MyCartScreen.CartViewModel
import com.example.nectar.ui.theme.NectarTheme


val imageUrls = listOf(
    R.drawable.img_banner1,
    R.drawable.img_banner2,
    R.drawable.img_banner3
)


@Composable
fun HomeScreen(
    modifier : Modifier = Modifier.padding(16.dp),
    navController: NavController,
    HomeviewModel: HomeScreenViewModel = hiltViewModel(),
    cartViewModel: CartViewModel = hiltViewModel()
){

        HomeBody(
            navController,
            modifier = modifier.padding(16.dp),
            viewModel = HomeviewModel,
            cartViewModel = cartViewModel
        )
}

@Composable

fun HomeBody(
    navController: NavController,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
    viewModel: HomeScreenViewModel,
    cartViewModel: CartViewModel

){

    val products = viewModel.products.collectAsState()
    val cartItemIds by cartViewModel.cartItemIds.collectAsState()


    LazyColumn(
        contentPadding = contentPadding,
    ) {
        item {HomeScreenBar(navController) }
        item { BannerSlider(imageUrls)}

        item { HomeCategory(navController = navController,
            text = "Exclusive Offers",
            products = products.value,
            cartItemsId = cartItemIds,
            cartViewModel = cartViewModel)}

        item { HomeCategory(navController = navController,
            text = "Best Selling",
            products = products.value,
            cartItemsId = cartItemIds,
            cartViewModel = cartViewModel)}
        item { GroceriesRow(navController,
            title = "Groceries",
            products =  products.value,
            cartItemsId = cartItemIds,
            cartViewModel = cartViewModel) }
    }


}


@Composable
fun BannerSlider(images: List<Int>) {
    val pagerState = rememberPagerState(pageCount = { images.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 8.dp)
    ) { page ->
        val imageUrl = images[page]

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
               // fallback background in case image fails
        ) {
            Image(
                painter = painterResource(imageUrl),
                contentDescription = "Slide $page",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenBar(
    navController: NavController,
    query: String = "",
    onQueryChange: () -> Unit ={}
){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp).padding(bottom = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.group__1_),
                    contentDescription = null,
                    modifier = Modifier
                        .width(26.48.dp)
                        .height(30.dp)
                )
                Row(
                    modifier = Modifier.padding(8.dp)
                ){
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null
                    )
                    Text("Dhaka, Banassre", fontSize = 18.sp)
                }
                FakeSearchBar(navController)
            }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    NectarTheme {
//        GroceriesRow()
    }
}