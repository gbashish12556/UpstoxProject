package com.example.upstoxproject.presentation.stock_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upstoxproject.common.Constants
import com.example.upstoxproject.domain.use_case.GetStocksUseCase
import com.example.upstoxproject.common.Resource
import com.example.upstoxproject.presentation.models.StockListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StockListViewModel @Inject constructor(
    val getStocksUseCase: GetStocksUseCase

): ViewModel(){

    private val _state = mutableStateOf(StockListState())
    val state = _state

    init {

            getStocks()


    }

    private fun getStocks() {

        getStocksUseCase().onEach {result->
            when(result){
                is Resource.Success->{
                    _state.value = StockListState(stocks = result.data)
                }
                is Resource.Error->{
                    _state.value = StockListState(error = result.message?:"Something went wrong")
                }
                is Resource.Loading->{
                    _state.value = StockListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}