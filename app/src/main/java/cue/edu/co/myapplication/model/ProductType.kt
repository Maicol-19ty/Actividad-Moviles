package cue.edu.co.myapplication.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import cue.edu.co.myapplication.R
import cue.edu.co.myapplication.ui.theme.ClothingPurple
import cue.edu.co.myapplication.ui.theme.FoodRed
import cue.edu.co.myapplication.ui.theme.HomeGreen
import cue.edu.co.myapplication.ui.theme.TechBlue

enum class ProductType(val label: String, @DrawableRes val imageRes: Int, val accent: Color) {
    TECHNOLOGY("Technology", R.drawable.ic_type_technology, TechBlue),
    CLOTHING("Clothing", R.drawable.ic_type_clothing, ClothingPurple),
    FOOD("Food", R.drawable.ic_type_food, FoodRed),
    HOME("Home", R.drawable.ic_type_home, HomeGreen),
}
