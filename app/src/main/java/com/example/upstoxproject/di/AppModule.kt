package com.example.upstoxproject.di

import com.example.upstoxproject.data.remote.UpstoxApi
import com.example.upstoxproject.data.repository.UpstoxRepoImpl
import com.example.upstoxproject.domain.repository.UpstoxRepo
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
    fun providePaprikaApi():UpstoxApi{

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(UpstoxApi::class.java)

    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:UpstoxApi): UpstoxRepo {
        return UpstoxRepoImpl(api)
    }


}