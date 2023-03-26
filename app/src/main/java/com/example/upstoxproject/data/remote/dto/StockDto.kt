package com.example.upstoxproject.data.remote.dto

import com.example.upstoxproject.domain.models.Stock

data class StockDto(

    val avg_price: String,
    val ltp: Double,
    val quantity: Int,
    val symbol: String,
    val close: Double,

    val cnc_used_quantity: Int,
    val collateral_qty: Int,
    val collateral_type: String,
    val collateral_update_qty: Int,
    val company_name: String,
    val haircut: Double,
    val holdings_update_qty: Int,
    val isin: String,
    val product: String,
    val t1_holding_qty: Int,
    val token_bse: String,
    val token_nse: String,
    val withheld_collateral_qty: Int,
    val withheld_holding_qty: Int
)

fun StockDto.toStock():Stock{
    return Stock(
        ltp = ltp,
        quantity = quantity,
        symbol = symbol,
        currentValue = ltp*quantity,
        investmentValue = avg_price.toDouble()*quantity,
        pnl = ((close-ltp)*quantity)
    )
}