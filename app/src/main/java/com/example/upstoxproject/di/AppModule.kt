package com.example.upstoxproject.di

import com.example.upstoxproject.data.remote.StocksApi
import com.example.upstoxproject.data.repository.StocksRepoImpl
import com.example.upstoxproject.domain.repository.StocksRepo
import com.plcoding.cryptocurrencyappyt.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providePaprikaApi():StocksApi{

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(StocksApi::class.java)

    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:StocksApi): StocksRepo {
        return StocksRepoImpl(api)
    }


}