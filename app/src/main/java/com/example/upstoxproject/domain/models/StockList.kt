package com.example.upstoxproject.domain.models

class StockList (

    var stockList:List<Stock> = emptyList(),
    var currentValue:Double = 0.0,
    var totalInvestment:Double = 0.0,
    var todayPnl:Double = 0.0

        )