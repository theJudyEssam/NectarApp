package com.example.nectar.ui.screens.OrderAcceptedScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nectar.R
import com.example.nectar.ui.theme.BlackN
import com.example.nectar.ui.theme.Gilroy
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.GreyN
import com.example.nectar.ui.theme.NectarTheme


@Composable
fun OrderAcceptedScreen(
    navController: NavController
){

    Box(){
        Image(
            painter = painterResource(R.drawable.mask_group),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        OrderAcceptedContent(
            onClick = {navController.navigate("home")},
            modifier = Modifier.align(Alignment.BottomStart)
        )





    }
}


@Composable
fun OrderAcceptedContent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Image(
            painter = painterResource(R.drawable.group_6872),
            contentDescription = "Order Accepted",
            modifier = modifier
                .width(269.0780029296875.dp)
                .height(240.30690002441406.dp)
                .padding( 16.dp)
        )

        Text("Your Order has been Accepted",
            style = TextStyle(
                fontFamily = Gilroy,
                fontWeight = FontWeight.W600,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            ),
            modifier = modifier.padding(top = 16.dp))


        Text(
            "Your items has been placedd and is on \n" +
                    "it’s way to being processed",
                    style = TextStyle(
                        fontFamily = Gilroy,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        textAlign = TextAlign.Center,
                        color = GreyN
                    ),
            modifier = modifier.padding(8.dp)
        )


        Spacer(modifier.padding(32.dp))

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
            Text("Track your Order")
        }

        Button(
            onClick = {onClick()},
            modifier = modifier
                .width(353.dp)
                .height(67.dp)
                .padding(4.dp),
            shape = RoundedCornerShape(19.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent // or any other Color
            )
        ){
            Text("Back to Home", color = BlackN)
        }




    }

}



@Preview(showBackground = true)
@Composable
fun OrderAcceptedPreview(){
    NectarTheme {
    }
}