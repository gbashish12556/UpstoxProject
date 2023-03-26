package com.example.upstoxproject.domain.repository

import com.example.upstoxproject.common.Resource
import com.example.upstoxproject.domain.models.StockList

interface StocksRepo {

    suspend fun getStocks(): Resource<StockList>

}