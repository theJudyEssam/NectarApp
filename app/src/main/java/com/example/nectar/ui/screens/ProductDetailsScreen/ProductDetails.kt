package com.example.nectar.ui.screens.ProductDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nectar.ui.theme.Gilroy
import com.example.nectar.ui.theme.NectarTheme


@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier
){

    ProductBody()
}


@Composable
fun ProductBody(
    modifier: Modifier = Modifier,
    productURL:String = "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png",
    productName: String = "Random Product",
    productDetails: String = "13, price",
    productDescription: String = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
    productReview:Int = 4,
    productNutrition: Map<String, String> = emptyMap(),
    productPrice: Float = 0.0f
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(16.dp)
            ) {

                Column(
                    modifier = modifier.weight(1f)
                ){
                    Text(productName,
                        style = TextStyle(
                            fontFamily = Gilroy,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp, 
                            lineHeight = 18.sp,
                            textAlign = TextAlign.Center
                        ))
                    Text(productDetails,
                        style = MaterialTheme.typography.labelSmall)
                }

                IconButton(
                    onClick = {} // no favourites so no implementation
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null
                    )
                }

            }
        }

        item{

        }
    }


}



@Preview(showBackground = true)
@Composable
fun ProductScreenPreview(){
    NectarTheme {
        ProductDetailsScreen()
    }
}