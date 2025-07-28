package com.example.nectar.ui.components

import android.R
import android.provider.ContactsContract
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.theme.BlackN
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.GreyN
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.WhiteN


@Composable
fun ProductViewItem(
    image: String = "https://img.freepik.com/premium-photo/cucumber-isolated-white-background_319514-5406.jpg](https://img.freepik.com/premium-photo/cucumber-isolated-white-background_319514-5406.jpg",
    title: String = "Apples",
    details: String = "333ml, Price",
    price: Float = 3.99f,
    modifier: Modifier = Modifier,
    addCart: () -> Unit = {},
    isInCart: Boolean = false
){

    Column(
        modifier = modifier
            .border(1.dp, shape = RoundedCornerShape(18.dp), color = Color(0xFFE2E2E2))
            .padding(8.dp)
            .width(173.32.dp)
            .height(248.51.dp)
    ){


        PhotoCard(
            image,
            93.21.dp,
            93.21.dp
        )

        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(modifier = modifier.padding(2.dp))

        Text(
            text = details,
            style = MaterialTheme.typography.labelSmall
        )

        Spacer(modifier = modifier.padding(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "$price$",
                style = MaterialTheme.typography.labelMedium,
                modifier = modifier.weight(1f)
            )

            AddButton(
                onClick = { addCart() },
                isInCart = isInCart
            )
        }
    }
}


@Composable
fun AddButton(
    onClick: () -> Unit,
    isInCart:Boolean = false
){
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .background(GreenN, shape = RoundedCornerShape(17.dp))
    ){
        Icon(
            imageVector = if (isInCart) Icons.Default.Check else Icons.Default.Add,
            contentDescription = "Add to cart Button",
            tint = WhiteN
        )
    }
}




@Preview(showBackground = true)
@Composable
fun ProductViewItemPreview(){
    NectarTheme {
        ProductViewItem()
    }
}