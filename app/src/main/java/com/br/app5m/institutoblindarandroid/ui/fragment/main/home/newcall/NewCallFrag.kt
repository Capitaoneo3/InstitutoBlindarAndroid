package com.br.app5m.institutoblindarandroid.ui.fragment.main.home.newcall

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.MyUseFulKotlin
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.model.Message
import com.br.app5m.institutoblindarandroid.ui.adapter.Audio_previewmini_adapter
import com.br.app5m.institutoblindarandroid.ui.adapter.Last_calls_adapter
import com.br.app5m.institutoblindarandroid.ui.dialog.AudioPrevDetailDialog
import kotlinx.android.synthetic.main.new_call_fragment.*
import kotlinx.android.synthetic.main.ultimos_5_chamados_abertos.*

class NewCallFrag : Fragment() {
    private val CHOOSE_FILE_REQUESTCODE = 8777
    private val PICKFILE_RESULT_CODE = 8778
    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList = java.util.ArrayList<Message>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_call_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createLast_calls()
        configureLast_callsAdapter()
        clicks()


    }
    fun clicks(){
/*   sendButton.setOnClickListener {
            findNavController().navigateUp()

        }*/
        fabFotos.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "file/*"
            startActivityForResult(intent, PICKFILE_RESULT_CODE)
        }
        fabArquivos.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "file/*"
            startActivityForResult(intent, PICKFILE_RESULT_CODE)
        }
        fabGravador.setOnClickListener {
            findNavController().navigate(R.id.action_newCallFrag_to_sendingAudioFragment)
        }

    }

    fun configureLast_callsAdapter(){
        callsAdapter = Audio_previewmini_adapter(callsList, object : RecyclerItemClickListener {
            override fun onClickListenerAudioPreviewAdapter(message: Message) {
                super.onClickListenerAudioPreviewAdapter(message)
                dialogshow()



            }


        },requireContext())


        val vmProduct = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        audiosRv.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(512)
            callsAdapter.setHasStableIds(true)
            layoutManager = vmProduct
            adapter = callsAdapter

        }

    }

    fun createLast_calls() {

        callsList.clear()
        var category = Message( )
        callsList.add(category)
        category = Message( )
        callsList.add(category)
        category = Message( )
        callsList.add(category)
        category = Message( )
        callsList.add(category)
        category = Message( )
        callsList.add(category)


    }


    fun dialogshow(){
        val dialog = AudioPrevDetailDialog()

        dialog.setTargetFragment(this, 1)
        fragmentManager?.let { it1 -> dialog.show(it1, "AdresseDialog") }
    }
}