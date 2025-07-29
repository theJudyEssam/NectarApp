package com.example.nectar.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.theme.GreenN
import com.example.nectar.ui.theme.GreyN
import com.example.nectar.ui.theme.Minus
import com.example.nectar.ui.theme.WhiteN

@Composable
fun NumericCounter(
    modifier: Modifier = Modifier,
    value: Int,
    onIncrement: (Int) -> Unit,
    onDecrement: (Int) -> Unit,
    min: Int = 0,
    max: Int = 100
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
    ) {
        IconButton(
            onClick = { onDecrement(value - 1); Log.d("Decrement Button", "Pressed on decrement $value")},
            enabled = true
        ) {
            Icon(imageVector = Minus, contentDescription = "Decrease")
        }

        Text(
            text = value.toString(),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
                .background(color = WhiteN, shape = RoundedCornerShape(12.dp))
        )

        IconButton(
            onClick = { if (value < max) onIncrement(value + 1) },
            enabled = true
        ) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "Increase",
                tint = GreenN)
        }
    }
}