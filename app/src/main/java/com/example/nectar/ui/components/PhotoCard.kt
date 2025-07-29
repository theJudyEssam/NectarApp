package com.example.nectar.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.
        padding(16.dp)
            .width(width)
            .height(height)
            .clip(RoundedCornerShape(12.dp))

    )

}