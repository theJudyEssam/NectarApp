package com.example.nectar

import androidx.compose.ui.graphics.Color

enum class PriceFilters(val Name:String){
    LOWEST("Lowest"),
    HIGHEST("Highest")
}

enum class Categories(val Name:String, val Color: Color, val ImgSrc: String){
    FRUITS("Fresh Fruits & Vegetable", Color(0xFF53B175).copy(alpha = 0.15f), "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png](https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png"),
    COOKING("Cooking Oil & Ghee", Color(0xF8A44CB2), "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png](https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png"),
    MEAT("Meat & Fish", Color(0xF7A59340), "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png](https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png"),
    BAKERY("Bakery & Snacks", Color(0xD3B0E040), "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png](https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png"),
    DIARY("Dairy & Eggs", Color(0xFDE59840), "https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png](https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png"),
    BEVERAGES("Beverages", Color(0xB7DFF540),"https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png](https://www.pikpng.com/pngl/b/197-1975663_oil-sunflower-canola-cooking-seed-rapeseed-oils-clipart.png")
}
