package com.example.upstoxproject.data.remote.dto

data class StockListResponse(
    val client_id: String,
    val `data`: List<StockDto>,
    val error: Any,
    val response_type: String,
    val timestamp: Long
)