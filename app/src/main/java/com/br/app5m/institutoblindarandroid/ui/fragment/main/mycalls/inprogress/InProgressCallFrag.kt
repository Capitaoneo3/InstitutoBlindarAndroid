package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.inprogress

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.MyUseFulKotlin
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.ui.adapter.Last_calls_adapter
import com.br.app5m.institutoblindarandroid.ui.fragment.main.home.HomeViewModel
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.pending.PendingCallFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.pending.PendingCallViewModel
import kotlinx.android.synthetic.main.in_progress_call_fragment.*
import kotlinx.android.synthetic.main.pending_call_fragment.*
import kotlinx.android.synthetic.main.pending_call_fragment.pendingCall_Rv

class InProgressCallFrag : Fragment() {
    private lateinit var alertDialog: AlertDialog
    private lateinit var builder: AlertDialog.Builder

    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<Call>()
    companion object {
        fun newInstance() = InProgressCallFrag()
    }

    private lateinit var viewModel: InProgressCallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.in_progress_call_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InProgressCallViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        builder = AlertDialog.Builder(requireContext())
        alertDialog = builder.create()
        createLast_calls()
        configureLast_callsAdapter()
    }
    fun configureLast_callsAdapter(){
        callsAdapter = Last_calls_adapter(callsList, object : RecyclerItemClickListener {
            override fun onClickListenerLastCallsAdapter(call: Call) {
                super.onClickListenerLastCallsAdapter(call)

//                findNavController().navigate(R.id.action_checkout1Frag_to_checkout2Frag2)

            }

        },requireContext())


        val vmProduct = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        InProgressCall_Rv.apply {
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
            InProgressCall_Rv.addItemDecoration(itemDecoration)




            layoutManager = vmProduct
            adapter = callsAdapter




        }

    }

    fun createLast_calls() {
        MyUseFulKotlin().openLoading(requireContext(), alertDialog)
        MyUseFulKotlin().closeLoading( alertDialog)

        callsList.clear()
        var category = Call( "Advogados","Em Andamento", R.drawable.ic_baseline_balance_24)
        callsList.add(category)
        category = Call( "Médicos","Em Andamento", R.drawable.ic_baseline_medical_services_24)
        callsList.add(category)
        category = Call( "Jornalistas","Em Andamento", R.drawable.ic_microphone_)
        callsList.add(category)
        category = Call( "Administradores","Em Andamento", R.drawable.ic_noun_administrator_1046321)
        callsList.add(category)


    }
}