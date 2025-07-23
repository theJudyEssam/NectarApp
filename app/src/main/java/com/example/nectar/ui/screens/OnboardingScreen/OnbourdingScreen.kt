package com.example.nectar.ui.screens.OnboardingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.WhiteN


@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.onboarding_img),
            contentDescription = "Onboarding image",
            modifier = modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(36.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.carrot),
                contentDescription = null,
                modifier = modifier
                    .width(48.47047424316406.dp)
                    .height(56.36478805541992.dp)
            )
            Text(
                "Welcome",
                style = MaterialTheme.typography.displayLarge,
                color = WhiteN,
                modifier = modifier.padding(top = 16.dp)

            )
            Text(
                "to our store",
                style = MaterialTheme.typography.displayLarge,
                color = WhiteN
            )

            Text(
              " Get your groceries in as fast as one hour",
                style = MaterialTheme.typography.displaySmall,
                color = WhiteN,
            )
            Spacer(modifier.padding(16.dp))
            Button(
                onClick = onClick,
                modifier = modifier
                    .width(353.dp)
                    .height(67.dp),
                shape = RoundedCornerShape(19.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenN // or any other Color
                )
            ) {
                Text("Get Started", style = MaterialTheme.typography.labelMedium)
            }

        }



    }
}







@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview(){
    NectarTheme {
        OnBoardingScreen()
    }
}