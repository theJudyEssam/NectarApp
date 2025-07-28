package com.example.nectar.ui.screens.MyCartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.nectar.ui.components.NumericCounter
import com.example.nectar.ui.theme.GreenN


@Composable
fun CartsScreen(
    navController: NavController
){
    Scaffold(
        topBar = {CartNavBar()}
    ) {
        innerPadding ->
        CartsBody(navController,
            modifier = Modifier.padding(innerPadding),
            contentPadding = innerPadding)
    }
}

@Composable
fun CartsBody(
    navController: NavController,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues()
){

    Box(){
        LazyColumn(
            contentPadding = contentPadding
        )
        {
            items(10){
//                CartItem(
//                    modifier = Modifier.clickable(
//                        onClick = { navController.navigate("product/${0}") }
//                    )
//                )
            }
        }


        Button(
            onClick = {navController.navigate("order_accepted")},
            modifier = Modifier
                .width(353.dp)
                .height(67.dp)
                .align(Alignment.BottomCenter)
                .padding(4.dp),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenN // or any other Color
            )
        ){
            Text("Proceed to checkout")
        }
    }




}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartNavBar(){

    CenterAlignedTopAppBar(
        title = {
            Text(
                "Cart",
                style = MaterialTheme.typography.titleMedium)
        }
    )
}


@Composable
fun CartItem(
    modifier: Modifier = Modifier,
    onQuantityChange: (Int) -> Unit = {},
    productImg: String = "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png",
    productName: String = "Product Name",
    productDetail:String = "1kg, Price",
    productQuantity:Int = 1,
    productPrice: Float = 4.99f
){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)
    ){
        Image(
            painter = rememberAsyncImagePainter(productImg),
            contentDescription = null,
            modifier = modifier
                .width(86.74077606201172.dp)
                .height(86.74077606201172.dp)
        )

        Column(
            modifier = modifier.padding(8.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(4.dp)
            ){
                Column(
                    modifier = modifier.weight(1f)
                ){
                    Text(
                        productName,
                        style = MaterialTheme.typography.labelMedium
                    )

                    Text(
                        productDetail,
                        style = MaterialTheme.typography.labelSmall
                    )
                }

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null
                    )
                }

            }

            // Numeric Counter Price
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(4.dp)
            ){
                NumericCounter(
                    modifier= modifier.weight(1f),
                    value = productQuantity,
                    onValueChange = onQuantityChange
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    "$productPrice$",
                    style = MaterialTheme.typography.labelMedium
                )

                



            }
        }

    }

}



@Preview(showBackground = true)
@Composable
fun CartScreenPreview(){
}