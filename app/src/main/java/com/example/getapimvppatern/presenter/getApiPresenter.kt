package com.example.getapimvppatern.presenter

import android.util.Log
import android.widget.Toast
import com.example.getapimvppatern.model.ResponseGetApi
import com.example.getapimvppatern.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//todo 6 counstruct interfece
class getApiPresenter(var apiKK:getApiView) {

    //todo 4 membuat fungsi tanpa parameter
    fun getApi()
    {
        ConfigNetwork.getRetrofit().getData().enqueue(object : Callback<ResponseGetApi>{
            override fun onFailure(call: Call<ResponseGetApi>, t: Throwable) {
                Log.d("Gagal",t.message?:"")
                apiKK.onError(t.message?:"")
            }

            override fun onResponse(call: Call<ResponseGetApi>, response: Response<ResponseGetApi>) {
                if (response.isSuccessful)
                {
                    val data =response.body()?.articles
                    if (data?.size?:0>0)
                    {
                        Log.d("Koneksi Berhasil",response.message())

                        // todo 7 memanggil interface jika sukses
                        apiKK.onSucces(response.message(),data)
                    }
                    else
                    {
                        // todo 8 memanggil interface jika gagal
                        Log.d("Koneksi Gagal",response.message())
                        apiKK.onError(response.message())
                    }
                }
            }

        })
    }
}