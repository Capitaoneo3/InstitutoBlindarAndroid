package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.archives

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.MyUseFulKotlin
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.model.Message
import com.br.app5m.institutoblindarandroid.ui.adapter.Files_adapter
import com.br.app5m.institutoblindarandroid.ui.adapter.Message_adapter
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.message.MessagesFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.message.MessagesViewModel
import kotlinx.android.synthetic.main.archives_fragment.*
import kotlinx.android.synthetic.main.messages_fragment.messagesRv
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import java.io.File


class ArchivesFrag : Fragment() {
    private val CHOOSE_FILE_REQUESTCODE = 8777
    private val PICKFILE_RESULT_CODE = 8778
    private lateinit var alertDialog: AlertDialog
    private lateinit var builder: AlertDialog.Builder

    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<Message>()
    companion object {
        fun newInstance() = ArchivesFrag()
    }

    private lateinit var viewModel: ArchivesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.archives_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArchivesViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        builder = AlertDialog.Builder(requireContext())
        alertDialog = builder.create()


        floatingActionButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "file/*"
            startActivityForResult(intent, PICKFILE_RESULT_CODE)
        }


        createLast_calls()
        configureLast_callsAdapter()
    }
    fun configureLast_callsAdapter(){
        callsAdapter = Files_adapter(callsList, object : RecyclerItemClickListener {


            override fun onClickListenerFileAdapter(mesage: Message) {
                super.onClickListenerFileAdapter(mesage)

                findNavController().navigate(R.id.action_detailCallFrag_to_vizualizeArchive)

            }

        },requireContext())


        val vmProduct = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        filesRv.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(512)
            callsAdapter.setHasStableIds(true)


            val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            itemDecoration.setDrawable(
                resources.getDrawable(
                    R.drawable.decor_layout_no_bg_vert,
                    null
                )
            )
            filesRv.addItemDecoration(itemDecoration)




            layoutManager = vmProduct
            adapter = callsAdapter




        }

    }

    fun createLast_calls() {
        MyUseFulKotlin().openLoading(requireContext(), alertDialog)
        MyUseFulKotlin().closeLoading( alertDialog)

        callsList.clear()
        var category = Message( "eu","0")
        callsList.add(category)
        category = Message( "Dr Izzac","1")
        callsList.add(category)
        category = Message( "eu","0")
        callsList.add(category)
        category = Message( "Dr Izzac","1")
        callsList.add(category)


    }
}

