package com.br.app5m.institutoblindarandroid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call

class Last_calls_adapter (private val callsList: List<Call>, val clickListener: RecyclerItemClickListener, context: Context):
    RecyclerView.Adapter<Last_calls_adapter.LastCallsHolder>() {

    val context = context
    private val viewPool = RecyclerView.RecycledViewPool()



    class LastCallsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name)
        val icon: ImageView = itemView.findViewById(R.id.icon)
        val status: TextView = itemView.findViewById(R.id.status)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastCallsHolder {

        return LastCallsHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_ultimos_5_chamados, parent, false))
    }

    override fun onBindViewHolder(callsHolder: LastCallsHolder, position: Int) {
        val call = callsList[position]

        callsHolder.icon.setImageDrawable(ContextCompat.getDrawable(context,call.icon!!))




        callsHolder.name.text = call.nome.toString()
        callsHolder.status.text = call.status.toString()



        callsHolder.itemView.setOnClickListener { clickListener.onClickListenerLastCallsAdapter(call) }

    }

    override fun getItemCount(): Int {
        return callsList.size
    }

}