package com.example.nectar.ui.screens.SearchScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.Categories
import com.example.nectar.domain.model.product
import com.example.nectar.domain.usecases.SearchProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject



@HiltViewModel
class SearchViewModel @Inject constructor(
    private val SearchProductUseCase: SearchProductUseCase
): ViewModel() {



    var _queryState = MutableStateFlow<String>(Categories.BEVERAGES.Name)
    val categoryState: StateFlow<String> get() =_queryState

    val products: StateFlow<List<product>> = _queryState
        .flatMapLatest {
                query ->
            SearchProductUseCase(query)
        }.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
        )


    fun Search(query: String){
        _queryState.value = query
        Log.d("Query log", "${_queryState.value}")
    }



}