package com.example.nectar.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PhotoCard(
    imagePath: String,
    width: Dp = 0.dp,
    height: Dp = 0.dp
){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current).data(imagePath)
            .crossfade(true).build(),
//        error = painterResource(R.drawable.ic_connection_error),
//        placeholder = painterResource(R.drawable.loading_img),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.
        padding(16.dp)
            .width(width)
            .height(height)
    )

}