package com.br.app5m.institutoblindarandroid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.MyUseFulKotlin
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.model.Message
import kotlinx.android.synthetic.main.archives_fragment.*
import androidx.recyclerview.widget.GridLayoutManager




class Forms_adapter (private val messageList: List<Message>, val clickListener: RecyclerItemClickListener, context: Context):
    RecyclerView.Adapter<Forms_adapter.FileHolder>() {
    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<Message>()
    val context = context
    private val viewPool = RecyclerView.RecycledViewPool()



    class FileHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val ll_he: LinearLayout = itemView.findViewById(R.id.ll_he)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileHolder {

        return FileHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_forms, parent, false))
    }

    override fun onBindViewHolder(fileHolder: FileHolder, position: Int) {
        val message = messageList[position]

/*
        if (message.id == "0"){
//            callsHolder.icon.setImageDrawable(ContextCompat.getDrawable(context,message.icon!!))

            fileHolder.HeFileLayout.visibility = View.GONE
            fileHolder.SelfFileLayout.visibility = View.VISIBLE
           fileHolder.nameSelf.text = message.nome.toString()

        }else{
            fileHolder.HeFileLayout.visibility = View.VISIBLE
            fileHolder.SelfFileLayout.visibility = View.GONE
            fileHolder.nameHe.text = message.nome.toString()
        }
*/




        fileHolder.ll_he.setOnClickListener { clickListener.onClickListenerFormsAdapter(message) }

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

}