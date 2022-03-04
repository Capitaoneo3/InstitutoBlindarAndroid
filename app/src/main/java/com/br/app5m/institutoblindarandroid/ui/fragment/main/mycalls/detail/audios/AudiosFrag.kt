package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.audios

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
import com.br.app5m.institutoblindarandroid.ui.adapter.Audio_adapter
import com.br.app5m.institutoblindarandroid.ui.adapter.Message_adapter
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.message.MessagesFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.message.MessagesViewModel
import kotlinx.android.synthetic.main.audios_fragment.*
import kotlinx.android.synthetic.main.messages_fragment.*
import kotlinx.android.synthetic.main.messages_fragment.messagesRv

class AudiosFrag : Fragment() {
    private lateinit var alertDialog: AlertDialog
    private lateinit var builder: AlertDialog.Builder

    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<Message>()
    companion object {
        fun newInstance() = AudiosFrag()
    }

    private lateinit var viewModel: AudiosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.audios_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AudiosViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        builder = AlertDialog.Builder(requireContext())
        alertDialog = builder.create()
        createLast_calls()
        configureLast_callsAdapter()
        recordButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailCallFrag_to_sendingAudioFragment)
        }
    }
    fun configureLast_callsAdapter(){
        callsAdapter = Audio_adapter(callsList, object : RecyclerItemClickListener {
            override fun onClickListenerLastCallsAdapter(call: Call) {
                super.onClickListenerLastCallsAdapter(call)

                findNavController().navigate(R.id.action_myCallsFrag_to_detailCallFrag)

            }

        },requireContext())


        val vmProduct = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        audiosRv.apply {
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
            audiosRv.addItemDecoration(itemDecoration)




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

