package com.example.nectar

import androidx.compose.ui.graphics.Color

enum class PriceFilters(val Name:String){
    LOWEST("Lowest"),
    HIGHEST("Highest")
}

enum class Categories(val Name:String, val Color: Color){
    FRUITS("Fresh Fruits & Vegetable", Color(0xFF53B175).copy(alpha = 0.15f)),
    COOKING("Cooking Oil & Ghee", Color(0xF8A44CB2)),
    MEAT("Meat & Fish", Color(0xF7A59340)),
    BAKERY("Bakery & Snacks", Color(0xD3B0E040)),
    DIARY("Dairy & Eggs", Color(0xFDE59840)),
    BEVERAGES("Beverages", Color(0xB7DFF540))
}
