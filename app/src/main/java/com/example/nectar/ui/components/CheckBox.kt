package com.example.nectar.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

fun <T> Set<T>.toggle(item:T): Set<T> {
    return if(contains(item)) this-item else this+item
}


@Composable
fun FilterCheckbox(
    name:String,
    checked : Boolean,
    onChecked : (String) -> Unit
){

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            name,
            style = MaterialTheme.typography.bodySmall
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { onChecked(name) }
        )
    }
}