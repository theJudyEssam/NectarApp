package com.example.nectar.ui.screens.ProductDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.nectar.data.model.Nutrition
import com.example.nectar.ui.screens.MyCartScreen.CartViewModel
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductDetailsSections
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductNameSection
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductNutritionSection
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductPriceSection
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductReviewSection
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.NectarTheme


//todo add share intent in application

@Composable
fun ProductDetailsScreen(
    productId: Int,
    ProductDetailsviewModel: ProductsDetailsViewModel = hiltViewModel(),
    CartViewModel: CartViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {}
){

    LaunchedEffect(productId) {
        ProductDetailsviewModel.fetchProduct(productId)
        CartViewModel.fetchCartItem(productId)
    }

    val product = ProductDetailsviewModel.product.collectAsState().value
    val quantity by CartViewModel.cartItemQuantity.collectAsState()


    Scaffold(
        topBar = { ProductNavBar(onBackClick = onBackClick) }
    ){
        innerPadding ->

        ProductBody(
            modifier = Modifier.padding(innerPadding),
            productURL = product.productImg,
            productNutrition = product.productNutrition,
            productName = product.productName,
            productDetails = product.productWeight,
            productDescription = product.productDescription,
            productPrice = product.productPrice,
            onAddCart = {CartViewModel.ToggleCartItem(product)},
            onIncrement = {CartViewModel.Increment(product)},
            onDecrement = {CartViewModel.Decrement(product)},
            CartQuantity = quantity
        )

    }


}


@Composable
fun ProductBody(
    modifier: Modifier = Modifier,
    productURL:String = "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png",
    productName: String = "Random Product",
    productDetails: String = "13, price",
    productDescription: String = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
    productReview:Int = 4,
    productNutrition: Nutrition,
    productPrice: Float = 0.0f,
    onAddCart: () -> Unit = {},
    onIncrement: (Int) -> Unit,
    onDecrement: (Int) -> Unit,
    CartQuantity: Int
){



    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ProductInfo(
            productName,
            productPrice,
            productReview,
            productURL,
            productDetails,
            productNutrition,
            productDescription,
            onIncrement,
            onDecrement,
            CartQuantity
        )

        Button(
            onClick = {onAddCart},
            modifier = modifier
                .width(353.dp)
                .height(67.dp)
                .padding(4.dp),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenN
            )
        ){
            Text(
                "Add to Basket",
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }



}

@Composable
fun ProductInfo(
    productName: String,
    productPrice: Float,
    productReview: Int,
    productURL: String,
    productDetails: String,
    productNutrition: Nutrition,
    productDescription: String,
    onIncrement: (Int) -> Unit,
    onDecrement: (Int) -> Unit,
    quantity: Int,
    modifier: Modifier = Modifier
){

    LazyColumn {
        item{
            Image(
                painter= rememberAsyncImagePainter(productURL),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(371.44.dp)
            )
        }
        item{
            ProductNameSection(productName = productName, productDetails = productDetails)
        }

        item{
            ProductPriceSection(
                productPrice,
                onIncrement = onIncrement,
                onDecrement = onDecrement,
                quantity = quantity)
        }
        item{ ProductDetailsSections(modifier,productDescription) }

        item{
            ProductNutritionSection(productNutrition = productNutrition)
        }
        item{
            ProductReviewSection(rating = productReview)
        }
    }


}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductNavBar(
    onBackClick: () -> Unit
){
    TopAppBar(
        title = {},
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
fun ProductScreenPreview(){
    NectarTheme {
    }
}