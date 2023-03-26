package com.example.upstoxproject.data.repository

import com.example.upstoxproject.common.Resource
import com.example.upstoxproject.data.remote.StocksApi
import com.example.upstoxproject.data.remote.dto.toStock
import com.example.upstoxproject.domain.models.StockList
import com.example.upstoxproject.domain.repository.StocksRepo
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class StocksRepoImpl@Inject constructor(

    private val api:StocksApi

):StocksRepo {

    override suspend fun getStocks(): Resource<StockList> {

        try {

            val stockList = api.getStocks().data.map { it.toStock() }

            val stocks = StockList(
                stockList = stockList,
                currentValue = stockList.sumOf { it.currentValue },
                totalInvestment = stockList.sumOf { it.investmentValue },
                todayPnl = stockList.sumOf { it.pnl }
            )
            return Resource.Success<StockList>(stocks)

        } catch (e: HttpException) {

            return Resource.Error<StockList>(
                message = e.localizedMessage ?: "An unexpected error occured"
            )

        } catch (e: IOException) {

            return Resource.Error<StockList>(message = "Couldn't reach server. Check your internet connection.")

        }
    }

}