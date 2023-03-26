package com.example.upstoxproject.data.repository

import com.example.upstoxproject.data.remote.StocksApi
import com.example.upstoxproject.data.remote.dto.toStock
import com.example.upstoxproject.domain.models.StockList
import com.example.upstoxproject.domain.repository.StocksRepo
import javax.inject.Inject

class StocksRepoImpl@Inject constructor(

    private val api:StocksApi

):StocksRepo {

    override suspend fun getStocks(): StockList {

        val stockList = api.getStocks().data.map { it.toStock() }

        return StockList(
            stockList = stockList,
            currentValue = stockList.sumOf { it.currentValue },
            totalInvestment = stockList.sumOf { it.investmentValue },
            todayPnl = stockList.sumOf { it.pnl }
        )

    }

}