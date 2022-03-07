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

class Message_adapter (private val messageList: List<Message>, val clickListener: RecyclerItemClickListener, context: Context):
    RecyclerView.Adapter<Message_adapter.MessageHolder>() {

    val context = context
    private val viewPool = RecyclerView.RecycledViewPool()



    class MessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val heText: TextView = itemView.findViewById(R.id.heText)
        val nameHe: TextView = itemView.findViewById(R.id.nameHe)
        val dateHe: TextView = itemView.findViewById(R.id.dateHe)
        val profile_imageHe: ImageView = itemView.findViewById(R.id.profile_imageHe)
        val heMessageLayout: ConstraintLayout = itemView.findViewById(R.id.heMessageLayout)

        val selfText: TextView = itemView.findViewById(R.id.selfText)
        val nameSelf: TextView = itemView.findViewById(R.id.nameSelf)
        val dateSelf: TextView = itemView.findViewById(R.id.dateSelf)
        val profile_imageSelf: ImageView = itemView.findViewById(R.id.profile_imageSelf)
        val SelfMessageLayout: ConstraintLayout = itemView.findViewById(R.id.SelfMessageLayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {

        return MessageHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_message, parent, false))
    }

    override fun onBindViewHolder(messageHolder: MessageHolder, position: Int) {
        val message = messageList[position]



        if (message.id == "0"){
//            callsHolder.icon.setImageDrawable(ContextCompat.getDrawable(context,message.icon!!))

            messageHolder.heMessageLayout.visibility = View.GONE
            messageHolder.SelfMessageLayout.visibility = View.VISIBLE
           messageHolder.nameSelf.text = message.nome.toString()
            if (message.text != null && message.text != "" ){
                messageHolder.selfText.text = message.text.toString()
            }

        }else{
            messageHolder.heMessageLayout.visibility = View.VISIBLE
            messageHolder.SelfMessageLayout.visibility = View.GONE
            messageHolder.nameHe.text = message.nome.toString()

        }




        messageHolder.itemView.setOnClickListener { clickListener.onClickListenerMessageAdapter(message) }

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

}