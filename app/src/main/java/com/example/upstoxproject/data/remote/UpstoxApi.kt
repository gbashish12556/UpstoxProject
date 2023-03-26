package com.example.upstoxproject.data.remote

import com.example.upstoxproject.data.remote.dto.StockList
import retrofit2.http.GET
import retrofit2.http.Path

interface UpstoxApi{

    @GET("v3/{userId}")
    suspend fun getStocks(@Path("userId") userId:String):StockList;


}