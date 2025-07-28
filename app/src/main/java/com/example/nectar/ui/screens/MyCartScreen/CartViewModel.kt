package com.example.nectar.ui.screens.MyCartScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.cart
import com.example.nectar.domain.model.product
import com.example.nectar.domain.usecases.DecrementUseCase
import com.example.nectar.domain.usecases.GetCartUseCase
import com.example.nectar.domain.usecases.IncrementUseCase
import com.example.nectar.domain.usecases.InsertCartUseCase
import com.example.nectar.domain.usecases.ToggleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val GetCartUseCase: GetCartUseCase,
    private val ToggleUseCase: ToggleUseCase,
    private val IncrementUseCase: IncrementUseCase,
    private val DecrementUseCase: DecrementUseCase
): ViewModel() {

    // getting all the cart items from the database
    val cart = GetCartUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    // adds/deletes the cart item
    // if it already exists --> deletes it from cart table
    // if it doesn't --> creates a cart object and adds it to table
    fun ToggleCartItem(product: product){
        viewModelScope.launch {
           ToggleUseCase(product)
        }
    }

    // incrementing the quantity by 1
    fun Increment(product: product){
        viewModelScope.launch {
            IncrementUseCase(product)
        }
    }

    // decrements quantity by 1, deletes if quantity goes below 1
    fun Decrement(product: product){
        viewModelScope.launch {
            DecrementUseCase(product)
        }
    }
}