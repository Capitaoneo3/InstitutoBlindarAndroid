package com.br.app5m.institutoblindarandroid.ui.fragment.main.forms

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.MyUseFulKotlin
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.ui.adapter.Forms_adapter
import kotlinx.android.synthetic.main.forms_fragment.*

class FormsFrag2 : Fragment() {
    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<com.br.app5m.institutoblindarandroid.model.Message>()
    companion object {
        fun newInstance() = FormsFrag2()
    }

    private lateinit var viewModel: FormsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.forms_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createLast_calls()
        configureLast_callsAdapter()
    }

    fun createLast_calls() {

        /*      MyUseFulKotlin().openLoading(requireContext(), alertDialog)
              MyUseFulKotlin().closeLoading( alertDialog)*/

        callsList.clear()
        var category = com.br.app5m.institutoblindarandroid.model.Message()
        callsList.add(category)
        category = com.br.app5m.institutoblindarandroid.model.Message()
        callsList.add(category)
        category = com.br.app5m.institutoblindarandroid.model.Message()
        callsList.add(category)
        category = com.br.app5m.institutoblindarandroid.model.Message()
        callsList.add(category)


    }

    fun configureLast_callsAdapter(){
        callsAdapter = Forms_adapter(callsList, object : RecyclerItemClickListener {
            override fun onClickListenerLastCallsAdapter(call: Call) {
                super.onClickListenerLastCallsAdapter(call)

                findNavController().navigate(R.id.action_navigation_home_to_detailCallFrag)

            }

        },requireContext())


        val vmProduct = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        formsRv.apply {
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
            formsRv.addItemDecoration(itemDecoration)




            layoutManager = vmProduct
            adapter = callsAdapter




        }

    }

}