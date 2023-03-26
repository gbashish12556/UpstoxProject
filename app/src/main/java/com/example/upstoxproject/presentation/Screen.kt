package com.example.upstoxproject.presentation

sealed class Screen(val route:String) {

    object StockListScreen:Screen("stock_list_screen")

}