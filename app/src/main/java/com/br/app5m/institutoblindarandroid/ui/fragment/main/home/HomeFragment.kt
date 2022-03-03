package com.br.app5m.institutoblindarandroid.ui.fragment.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.databinding.FragmentHomeBinding
import com.br.app5m.institutoblindarandroid.helper.MyUseFulKotlin
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.ui.adapter.Last_calls_adapter
import kotlinx.android.synthetic.main.buttons_top_home.*
import kotlinx.android.synthetic.main.ultimos_5_chamados_abertos.*

class HomeFragment : Fragment() {
    private lateinit var alertDialog: AlertDialog
    private lateinit var builder: AlertDialog.Builder

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<Call>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        builder = AlertDialog.Builder(requireContext())
        alertDialog = builder.create()

        clicks()

        createLast_calls()
        configureLast_callsAdapter()
    }
    fun configureLast_callsAdapter(){
        callsAdapter = Last_calls_adapter(callsList, object : RecyclerItemClickListener {
            override fun onClickListenerLastCallsAdapter(call: Call) {
                super.onClickListenerLastCallsAdapter(call)

                findNavController().navigate(R.id.action_navigation_home_to_detailCallFrag)

            }

        },requireContext())


        val vmProduct = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        last_calls_rv.apply {
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
            last_calls_rv.addItemDecoration(itemDecoration)




            layoutManager = vmProduct
            adapter = callsAdapter




        }

    }
fun clicks(){
    open_call_bt.setOnClickListener {
        findNavController().navigate(R.id.action_navigation_home_to_newCallFrag)
    }
}
    fun createLast_calls() {
        MyUseFulKotlin().openLoading(requireContext(), alertDialog)
        MyUseFulKotlin().closeLoading( alertDialog)

        callsList.clear()
        var category = Call( "Advogados","Pendente", R.drawable.ic_baseline_balance_24)
        callsList.add(category)
        category = Call( "Médicos","Pendente", R.drawable.ic_baseline_medical_services_24)
        callsList.add(category)
        category = Call( "Jornalistas","Aprovado", R.drawable.ic_microphone_)
        callsList.add(category)
        category = Call( "Administradores","Aprovado", R.drawable.ic_noun_administrator_1046321)
        callsList.add(category)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}