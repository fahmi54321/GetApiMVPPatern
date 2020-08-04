package com.example.getapimvppatern.network

import com.example.getapimvppatern.model.ResponseGetApi
import retrofit2.Call
import retrofit2.http.GET

interface ConfigInterface {

    //todo 2
    @GET("everything?q=bitcoin&from=2020-06-18&sortBy=publishedAt&apiKey=98745cd7bc464f08bc400fd27bf5282e")
    fun getData(): Call<ResponseGetApi>
}