package com.br.app5m.institutoblindarandroid.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Message(nome: String,id: String) {
    val status:  String? = null

    @SerializedName("image")
    @Expose
    val image: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = id

    @SerializedName("nome")
    @Expose
    var nome:String =  nome

    @SerializedName("data")
    @Expose
    var data:String? = null

    @SerializedName("text")
    @Expose
    var text:String? =  null
}