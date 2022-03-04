package com.br.app5m.institutoblindarandroid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Message
import rm.com.audiowave.AudioWaveView

class Files_chield_adapter (private val messageList: List<Message>, val clickListener: RecyclerItemClickListener, context: Context):
    RecyclerView.Adapter<Files_chield_adapter.AudioHolder>() {

    val context = context
    private val viewPool = RecyclerView.RecycledViewPool()



    class AudioHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

//        val profile_imageHe: ImageView = itemView.findViewById(R.id.profile_imageHe)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioHolder {

        return AudioHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_files_chield, parent, false))
    }

    override fun onBindViewHolder(audioHolder: AudioHolder, position: Int) {
        val message = messageList[position]



/*        if (message.id == "0"){
//            callsHolder.icon.setImageDrawable(ContextCompat.getDrawable(context,message.icon!!))

            audioHolder.heMessageLayout.visibility = View.GONE
            audioHolder.SelfMessageLayout.visibility = View.VISIBLE
           audioHolder.nameSelf.text = message.nome.toString()


        }else{
            audioHolder.heMessageLayout.visibility = View.VISIBLE
            audioHolder.SelfMessageLayout.visibility = View.GONE
            audioHolder.nameHe.text = message.nome.toString()

        }*/




        audioHolder.itemView.setOnClickListener { clickListener.onClickListenerFileChieldAdapter(message) }

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

}