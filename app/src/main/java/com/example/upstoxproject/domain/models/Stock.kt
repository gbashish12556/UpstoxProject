package com.example.upstoxproject.domain.models


data class Stock(

    val ltp: Double,
    val quantity: Int,
    val symbol: String,
    val currentValue:Double,
    val investmentValue:Double,
    val pnl:Double
    )