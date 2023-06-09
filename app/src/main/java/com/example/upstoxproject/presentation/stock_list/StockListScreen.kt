package com.example.upstoxproject.presentation.stock_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.upstoxproject.presentation.stock_list.component.StockListItem
import androidx.compose.ui.res.stringResource

@Composable
fun StockListScreen(
    viewModel: StockListViewModel =  hiltViewModel()
){
    val state = viewModel.state.value;
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

           state.stocks?.let {stocks->

               LazyColumn(modifier = Modifier.height(480.dp)){
                items(stocks.stockList){stock->

                    StockListItem(stock = stock)

                }
            }

              Row(modifier = Modifier
                  .fillMaxWidth()
                  .padding(10.dp),
                      horizontalArrangement = Arrangement.SpaceBetween) {

                  Text(text = "Current Value :")
                  Text(text = "Rs. ${stocks.currentValue}")

              }

               Row(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
                   horizontalArrangement = Arrangement.SpaceBetween) {

                   Text(text = "Total Investment :")
                   Text(text = "Rs. ${stocks.totalInvestment}")

               }

               Row(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
                   horizontalArrangement = Arrangement.SpaceBetween) {

                   Text(text = "Today's P/L :")
                   Text(text = "Rs. ${stocks.todayPnl}")

               }

               Row(modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp),
                   horizontalArrangement = Arrangement.SpaceBetween) {

                   Text(text = "Total P/L :")
                   Text(text = "Rs. ${(stocks.currentValue - stocks.totalInvestment)}")

               }

           }

        }


        if(!state.error.isNullOrBlank()){
            Text(
                text = state.error?:"NA",
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }

        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
        }

    }

}