package com.example.upstoxproject.data.repository

import com.example.upstoxproject.data.remote.UpstoxApi
import com.example.upstoxproject.data.remote.dto.StockList
import com.example.upstoxproject.domain.repository.UpstoxRepo
import javax.inject.Inject

class UpstoxRepoImpl@Inject constructor(

    private val api:UpstoxApi

):UpstoxRepo {

    override suspend fun getStocks(): StockList {
        TODO("Not yet implemented")
    }

}