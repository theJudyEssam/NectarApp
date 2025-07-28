package com.example.nectar.ui.screens.MyCartScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.cart
import com.example.nectar.domain.model.product
import com.example.nectar.domain.usecases.DecrementUseCase
import com.example.nectar.domain.usecases.GetCartUseCase
import com.example.nectar.domain.usecases.GetSpecificCartUseCase
import com.example.nectar.domain.usecases.IncrementUseCase
import com.example.nectar.domain.usecases.InsertCartUseCase
import com.example.nectar.domain.usecases.ObserveCartUseCase
import com.example.nectar.domain.usecases.ToggleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val GetCartUseCase: GetCartUseCase,
    private val ToggleUseCase: ToggleUseCase,
    private val IncrementUseCase: IncrementUseCase,
    private val DecrementUseCase: DecrementUseCase,
    private val ObserveCartUseCase: ObserveCartUseCase
): ViewModel() {

    val cart = GetCartUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    private val _productId = MutableStateFlow<Int?>(null)
    val productId: StateFlow<Int?> = _productId

    fun fetchCartItem(id:Int){
        _productId.value = id
    }
    val cartItemQuantity: StateFlow<Int> = _productId
        .filterNotNull()
        .flatMapLatest { id ->
            ObserveCartUseCase(id) // This must return a Flow<cart?>
                .map { it?.quantity ?: 0 }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            0
        )

    fun observeCartItemQuantity(productId: Int): Flow<Int> {
        return ObserveCartUseCase(productId).map { it?.quantity ?: 0 }
    }



    val cartItemIds = cart.map {
        items -> items.map {it.productId} }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    fun ToggleCartItem(product: product){
        viewModelScope.launch {
           ToggleUseCase(product)
        }
    }

    fun Increment(product: product){
        viewModelScope.launch {
            IncrementUseCase(product)
        }
    }
    fun Decrement(product: product){
        viewModelScope.launch {
            DecrementUseCase(product)
        }
    }




}