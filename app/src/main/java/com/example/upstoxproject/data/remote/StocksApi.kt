package com.example.upstoxproject.data.remote

import com.example.upstoxproject.data.remote.dto.StockListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface StocksApi{

    @GET("v3/6d0ad460-f600-47a7-b973-4a779ebbaeaf")
    suspend fun getStocks():StockListResponse;


}