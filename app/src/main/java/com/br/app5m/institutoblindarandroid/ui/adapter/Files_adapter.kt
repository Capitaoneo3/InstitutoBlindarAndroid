package com.br.app5m.institutoblindarandroid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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




class Files_adapter (private val messageList: List<Message>, val clickListener: RecyclerItemClickListener, context: Context):
    RecyclerView.Adapter<Files_adapter.FileHolder>() {
    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<Message>()
    val context = context
    private val viewPool = RecyclerView.RecycledViewPool()



    class FileHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameHe: TextView = itemView.findViewById(R.id.nameHe)
        val dateHe: TextView = itemView.findViewById(R.id.dateHe)
        val fileNameHe: TextView = itemView.findViewById(R.id.fileNameHe)
        val cardV_he: CardView = itemView.findViewById(R.id.cardV_he)
        val profile_imageHe: ImageView = itemView.findViewById(R.id.profile_imageHe)
        val HeFileLayout: ConstraintLayout = itemView.findViewById(R.id.HeFileLayout)

        val nameSelf: TextView = itemView.findViewById(R.id.nameSelf)
        val dateSelf: TextView = itemView.findViewById(R.id.dateSelf)
        val filennameSelf: TextView = itemView.findViewById(R.id.filennameSelf)
        val cardV_self: CardView = itemView.findViewById(R.id.cardV_self)
        val profile_imageSelf: ImageView = itemView.findViewById(R.id.profile_imageSelf)
        val SelfFileLayout: ConstraintLayout = itemView.findViewById(R.id.SelfFileLayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileHolder {

        return FileHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_files, parent, false))
    }

    override fun onBindViewHolder(fileHolder: FileHolder, position: Int) {
        val message = messageList[position]

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




        fileHolder.cardV_he.setOnClickListener { clickListener.onClickListenerFileAdapter(message) }
        fileHolder.cardV_self.setOnClickListener { clickListener.onClickListenerFileAdapter(message) }

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

}