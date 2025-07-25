package com.example.nectar

import androidx.compose.ui.graphics.Color

enum class PriceFilters(val Name:String){
    LOWEST("Lowest"),
    HIGHEST("Highest")
}

enum class Categories(val Name:String, val Color: Color){
    FRUITS("Fruits & Vegetables", Color(0xFF53B175).copy(alpha = 0.15f)),
    COOKING("Cooking Oil & Ghee", Color(0xFF53B175).copy(alpha = 0.15f)),
    MEAT("Meat & Fish", Color(0xFF53B175).copy(alpha = 0.15f)),
    BAKERY("Bakery & Snacks", Color(0xFF53B175).copy(alpha = 0.15f)),
    DIARY("Dairy & Eggs", Color(0xFF53B175).copy(alpha = 0.15f)),
    BEVERAGES("Beverages", Color(0xFF53B175).copy(alpha = 0.15f))
}
