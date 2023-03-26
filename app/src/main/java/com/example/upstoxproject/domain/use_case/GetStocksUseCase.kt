package com.example.upstoxproject.domain.use_case

import com.example.upstoxproject.common.Resource
import com.example.upstoxproject.domain.models.StockList
import com.example.upstoxproject.domain.repository.StocksRepo
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetStocksUseCase @Inject constructor(
    private val repository: StocksRepo
) {
    operator fun invoke() = flow {

            emit(Resource.Loading<StockList>())
            val stocks = repository.getStocks()
            emit(stocks)

    }
}