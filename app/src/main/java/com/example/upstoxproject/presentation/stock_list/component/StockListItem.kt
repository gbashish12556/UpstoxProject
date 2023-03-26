package com.example.upstoxproject.presentation.stock_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.upstoxproject.domain.models.Stock
import androidx.compose.ui.res.stringResource

@Composable
fun StockListItem(
    stock: Stock,
) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Column {


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

        Column {


            Text(
                text = "LTP : Rs ${stock.ltp}",
                color = Color.Black,
                style = MaterialTheme.typography.body1,
                overflow =  TextOverflow.Ellipsis
            )

            Text(
                text = "P/L : Rs. ${stock.pnl.toFloat()}",
                color = Color.Black,
                style = MaterialTheme.typography.body2,
                overflow =  TextOverflow.Ellipsis,
            )


        }

    }

    Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(color = Color.Black))

}