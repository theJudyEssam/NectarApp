package com.example.nectar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun NumericCounter(
    modifier: Modifier = Modifier,
    value: Int,
    onValueChange: (Int) -> Unit,
    min: Int = 0,
    max: Int = 100
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .background(Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
    ) {
        IconButton(
            onClick = { if (value > min) onValueChange(value - 1) },
            enabled = value > min
        ) {
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Decrease")
        }

        Text(
            text = value.toString(),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold
        )

        IconButton(
            onClick = { if (value < max) onValueChange(value + 1) },
            enabled = value < max
        ) {
            Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Decrease")
        }
    }
}