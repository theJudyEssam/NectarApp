package com.example.nectar.ui.screens.ProductDetailsScreen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.nectar.data.model.Nutrition
import com.example.nectar.domain.model.product
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductDetailsSections
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductNameSection
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductNutritionSection
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductPriceSection
import com.example.nectar.ui.screens.ProductDetailsScreen.Sections.ProductReviewSection
import com.example.nectar.ui.theme.Gilroy
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.NectarTheme


@Composable
fun ProductDetailsScreen(
    productId: Int,
    viewModel: ProductsDetailsViewModel = hiltViewModel()
){

    LaunchedEffect(productId) {
        viewModel.fetchProduct(productId)
    }
    val product = viewModel.product.collectAsState().value

    Log.d("product details", "${product.Id}")


    ProductBody(
        productURL = product.productImg,
        productNutrition = product.productNutrition,
        productName = product.productName,
        productDetails = product.productWeight,
        productDescription = product.productDescription,
        productPrice = product.productPrice
    )
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
    onAddCart: () -> Unit = {}
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
            productDescription
        )

        Button(
            onClick = {},
            modifier = modifier
                .width(353.dp)
                .height(67.dp)
                .padding(4.dp),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenN // or any other Color
            )
        ){
            Text(
                "Add to Basket",
                style = MaterialTheme.typography.labelMedium,
//              //  modifier = modifier.padding(16.dp)
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
            ProductPriceSection(productPrice)
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



@Composable
fun ProductNavBar(){

}




@Preview(showBackground = true)
@Composable
fun ProductScreenPreview(){
    NectarTheme {
    }
}