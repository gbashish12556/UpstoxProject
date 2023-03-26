package com.example.upstoxproject.domain.repository

import com.example.upstoxproject.data.remote.dto.StockList

interface UpstoxRepo {

    suspend fun getStocks(): StockList

}