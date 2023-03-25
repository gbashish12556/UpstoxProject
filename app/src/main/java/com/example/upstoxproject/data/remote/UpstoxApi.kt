package com.example.upstoxproject.data.remote

import com.example.upstoxproject.data.remote.dto.StockList
import retrofit2.http.GET
import retrofit2.http.Path

interface UpstoxApi{

    @GET("v3/6d0ad460-f600-47a7-b973-4a779ebbaeaf")
    suspend fun getCoins():StockList;


}