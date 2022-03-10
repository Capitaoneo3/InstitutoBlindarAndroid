package com.br.app5m.institutoblindarandroid.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Message {
    constructor(nome: String, id: String) {
        this.id = id
        this.nome = nome
    }

    constructor(nome: String, id: String,text:String) {
        this.id = id
        this.nome = nome
        this.text = text
    }
    constructor() {

    }


    val status:  String? = null

    @SerializedName("image")
    @Expose
    val image: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("nome")
    @Expose
    var nome: String? = null

    @SerializedName("data")
    @Expose
    var data: String? = null

    @SerializedName("text")
    @Expose
    var text: String? =  null
}