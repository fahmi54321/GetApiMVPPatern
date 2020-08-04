package com.example.getapimvppatern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.getapimvppatern.R
import com.example.getapimvppatern.adapter.ApiAdapter
import com.example.getapimvppatern.model.ArticlesItem
import com.example.getapimvppatern.presenter.getApiPresenter
import com.example.getapimvppatern.presenter.getApiView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), getApiView {

    // todo 9 deklarasi presenter
    var presenter:getApiPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // todo 10 inisialisasi presenter
        presenter = getApiPresenter(this)
        // todo 11 eksekusi presenter
        presenter?.getApi()
    }

    override fun onSucces(message: String, articles: List<ArticlesItem?>?) {
        //todo 12 bind data recycler view
        Toast.makeText(this,"Berhasil",Toast.LENGTH_LONG).show()
        rvGet.adapter = ApiAdapter(articles)
    }

    override fun onError(message: String) {
        //todo 13 jika bind data gagal
        Toast.makeText(this,"Data Kosong",Toast.LENGTH_LONG).show()
    }
}
