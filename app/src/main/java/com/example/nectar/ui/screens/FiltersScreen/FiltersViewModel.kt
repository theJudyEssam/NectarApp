package com.example.nectar.ui.screens.FiltersScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class FiltersState(
    val selectedCategories: Set<String> = emptySet(),
    val selectedPrices: Set<String> = emptySet()
)

@HiltViewModel
class FiltersViewModel @Inject constructor()
    : ViewModel() {

    private val _filterState = MutableStateFlow(FiltersState())
    val filterState: StateFlow<FiltersState> = _filterState

    fun setFilterState(filter: FiltersState){
        _filterState.value = filter
    }

}