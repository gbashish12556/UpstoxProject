package com.example.upstoxproject.presentation.models

import com.example.upstoxproject.domain.models.StockList


data class StockListState(

    val isLoading:Boolean = false,
    val error:String?  = null,
    val stocks:StockList? = null

)