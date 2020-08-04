package com.example.getapimvppatern.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ConfigNetwork {

    //todo 1
    companion object
    {
        fun getRetrofit() : ConfigInterface
        {
            val builder = OkHttpClient.Builder()
            builder.readTimeout(20, TimeUnit.SECONDS)
            builder.connectTimeout(20, TimeUnit.SECONDS)
            builder.writeTimeout(20, TimeUnit.SECONDS)

            val client = builder.build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(ConfigInterface::class.java)

            return service
        }
    }
}