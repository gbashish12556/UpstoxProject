package com.example.upstoxproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.upstoxproject.common.Constants
import com.example.upstoxproject.presentation.Screen
import com.example.upstoxproject.presentation.stock_list.StockListScreen
import com.example.upstoxproject.ui.theme.UpstoxProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val userId = "6d0ad460-f600-47a7-b973-4a779ebbaeaf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpstoxProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.StockListScreen.route ){

                        composable(
                            route = Screen.StockListScreen.route
                        ){
                            StockListScreen()
                        }


                    }
                }
            }
        }
    }
}
