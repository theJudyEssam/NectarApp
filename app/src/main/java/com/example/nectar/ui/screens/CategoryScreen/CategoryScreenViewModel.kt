package com.example.nectar.ui.screens.CategoryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.Categories
import com.example.nectar.domain.model.product
import com.example.nectar.domain.usecases.GetCategoryProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class CategoryScreenViewModel @Inject constructor(
    private val getCategoryProductsUseCase: GetCategoryProductsUseCase
): ViewModel(){

    //I will make Beverages the default category
    var _categoryState = MutableStateFlow<String>(Categories.BEVERAGES.Name)
    val categoryState: StateFlow<String> get() =_categoryState

    val products: StateFlow<List<product>> = _categoryState
        .flatMapLatest {
            category ->
            getCategoryProductsUseCase(category)
        }.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
        )

    fun getProductbyCategory(category: String){
        _categoryState.value = category
    }


}