package com.example.nectar.ui.screens.ProductDetailsScreen.Sections

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun ProductNutritionSection(
    modifier: Modifier = Modifier
){

    var nutritionVisible by remember { mutableStateOf(false) }

    Column(
        modifier =modifier.padding(16.dp)
    ){
        Row(){
            Text(
                "Nutrition",
                style = MaterialTheme.typography.labelMedium,
                modifier = modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Arrow Down",
                modifier = modifier.clickable(
                    enabled = true, onClick = {
                        nutritionVisible = !nutritionVisible
                    }
                )
            )
        }

        AnimatedVisibility(
            nutritionVisible == true        ) {
            Column( modifier = modifier.padding(8.dp)) {
                // for now i will put four oof those
                NutritionItem()
                NutritionItem()
                NutritionItem()
                NutritionItem()
            }
        }
    }

}


@Composable
fun NutritionItem(
    modifier: Modifier = Modifier,
    Type:String = "Calories",
    Amount:String = "100cal"
){

    Row(
        modifier = modifier.padding(4.dp)
    ){
        Text(
            Type,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Left,
            modifier = modifier.weight(1f))


        Text(
            Amount,
            style = MaterialTheme.typography.labelSmall
        )
    }
}