package com.example.getapimvppatern.presenter

import com.example.getapimvppatern.model.ArticlesItem

// todo 5 interface untuk jembatan antara presenter dengan view

interface getApiView {

    fun onSucces(message:String,articles: List<ArticlesItem?>?)
    fun onError(message:String)
}