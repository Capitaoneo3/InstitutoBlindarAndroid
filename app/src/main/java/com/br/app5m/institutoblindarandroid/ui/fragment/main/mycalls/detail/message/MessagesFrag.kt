package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.message

import android.content.ContentValues
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.MyUseFulKotlin
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.model.Message
import com.br.app5m.institutoblindarandroid.ui.adapter.Message_adapter
import kotlinx.android.synthetic.main.messages_fragment.*
import androidx.core.content.ContextCompat.getSystemService
import android.app.Activity
import android.view.inputmethod.InputMethodManager


class MessagesFrag : Fragment() {
    private lateinit var alertDialog: AlertDialog
    private lateinit var builder: AlertDialog.Builder
    private var textForm: String? =null

    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<Message>()
    companion object {
        fun newInstance() = MessagesFrag()
    }

    private lateinit var viewModel: MessagesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createLast_calls()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.messages_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MessagesViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        builder = AlertDialog.Builder(requireContext())
        alertDialog = builder.create()



        floatingActionButton.setOnClickListener {
            var text =    messageInput.text.toString()
            var category = Message( "eu","0",text)
            callsList.add(category)
           callsAdapter.notifyDataSetChanged()
            messageInput.setText("")
            //refrash no chat e descer automaticamente para baixo
            messagesRv.viewTreeObserver.addOnGlobalLayoutListener {
                (callsAdapter.itemCount - 1).takeIf { it > 0 }?.let(messagesRv::smoothScrollToPosition)
            }
            val imm: InputMethodManager =
                activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            //Find the currently focused view, so we can grab the correct window token from it.
            //Find the currently focused view, so we can grab the correct window token from it.
            var view = activity!!.currentFocus
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }






        configureLast_callsAdapter()
    }
    fun configureLast_callsAdapter(){
        callsAdapter = Message_adapter(callsList, object : RecyclerItemClickListener {
            override fun onClickListenerLastCallsAdapter(call: Call) {
                super.onClickListenerLastCallsAdapter(call)

                findNavController().navigate(R.id.action_myCallsFrag_to_detailCallFrag)

            }

        },requireContext())


        val vmProduct = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        messagesRv.apply {
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
            messagesRv.addItemDecoration(itemDecoration)




            layoutManager = vmProduct
            adapter = callsAdapter




        }

    }

    fun createLast_calls() {
  /*      MyUseFulKotlin().openLoading(requireContext(), alertDialog)
        MyUseFulKotlin().closeLoading( alertDialog)*/

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
