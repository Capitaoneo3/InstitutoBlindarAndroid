package com.br.app5m.institutoblindarandroid.helper

import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.model.Message


interface RecyclerItemClickListener {




    fun onClickListenerLastCallsAdapter(call: Call){
        //optional body
    }
    fun onClickListenerMessageAdapter(message: Message){
        //optional body
    }
    fun onClickListenerAudioAdapter(message: Message){
        //optional body
    }

}