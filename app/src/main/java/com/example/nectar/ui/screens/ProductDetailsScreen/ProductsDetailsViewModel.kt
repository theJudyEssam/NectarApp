package com.example.nectar.ui.screens.ProductDetailsScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.data.model.Nutrition
import com.example.nectar.domain.model.product
import com.example.nectar.domain.usecases.GetSpecificProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.collections.emptyList

var default_product: product = product(
    Id = 0,
    productName = "Default Product",
    productWeight = "0g",
    productImg = "", // or a placeholder URL if you prefer
    productPrice = 0.0f,
    productDescription = "No description available",
    productCategory = "Uncategorized",
    productRating = 0,
    productNutrition = Nutrition(
        protein = 0.0f,
        carbs = 0.0f,
        fat = 0.0f,
        fiber= 0.0f
    )
)


@HiltViewModel
class ProductsDetailsViewModel @Inject constructor(
    getSpecificProductUseCase: GetSpecificProductUseCase
): ViewModel() {

    var _id = MutableStateFlow<Int>(1)
    val id :StateFlow<Int> = _id

    val product = _id
        .flatMapLatest { id ->
            getSpecificProductUseCase(id)
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            default_product
        )


    fun fetchProduct(id:Int){

        _id.value = id
        Log.d("Product Id", "${_id.value}")
    }

}