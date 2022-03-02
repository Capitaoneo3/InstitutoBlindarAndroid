package com.br.app5m.institutoblindarandroid.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Call(nome: String,status:String, icon:Int) {
    val status:  String = status

    @SerializedName("icon")
    @Expose
    val icon=icon

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("nome")
    @Expose
    var nome:String =  nome
}