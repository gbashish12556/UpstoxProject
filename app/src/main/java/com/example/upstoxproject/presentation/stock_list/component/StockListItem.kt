package com.example.upstoxproject.presentation.stock_list.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.upstoxproject.domain.models.Stock

@Composable
fun StockListItem(
    stock: Stock,
) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Column(modifier = Modifier.width(200.dp)) {


            Text(
                text = "${stock.symbol}",
                color = Color.Black,
                style = MaterialTheme.typography.body1,
                overflow =  TextOverflow.Ellipsis
            )

            Text(
                text = "${stock.quantity}",
                color = Color.Black,
                style = MaterialTheme.typography.body2,
                overflow =  TextOverflow.Ellipsis,
            )

        }

        Column(modifier = Modifier.width(200.dp)) {


            Text(
                text = "LTP : Rs ${stock.ltp}",
                color = Color.Black,
                style = MaterialTheme.typography.body1,
                overflow =  TextOverflow.Ellipsis
            )

            Text(
                text = "P/L : Rs. ${stock.pnl}",
                color = Color.Black,
                style = MaterialTheme.typography.body2,
                overflow =  TextOverflow.Ellipsis,
            )

        }

    }

}