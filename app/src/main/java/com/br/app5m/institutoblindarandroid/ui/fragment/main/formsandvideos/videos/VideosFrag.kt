package com.br.app5m.institutoblindarandroid.ui.fragment.main.formsandvideos.videos

import android.Manifest
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.RecyclerItemClickListener
import com.br.app5m.institutoblindarandroid.model.Call
import com.br.app5m.institutoblindarandroid.model.Message
import com.br.app5m.institutoblindarandroid.ui.adapter.Videos_adapter
import com.br.app5m.institutoblindarandroid.ui.dialog.VideoDetailDialog
import kotlinx.android.synthetic.main.forms_fragment.*
import kotlinx.android.synthetic.main.forms_fragment.formsRv
import kotlinx.android.synthetic.main.videos_fragment.*

class VideosFrag : Fragment() {
    private lateinit var callsAdapter: RecyclerView.Adapter<*>
    private val callsList =
        java.util.ArrayList<com.br.app5m.institutoblindarandroid.model.Message>()

    companion object {
        fun newInstance() = VideosFrag()
    }

    private lateinit var viewModel: VideosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.videos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideosViewModel::class.java)
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

    fun configureLast_callsAdapter() {
        callsAdapter = Videos_adapter(callsList, object : RecyclerItemClickListener {
            override fun onClickListenerVideosAdapter(message: Message) {
                super.onClickListenerVideosAdapter(message)
            dialogshow()
            }

        }, requireContext())


        val vmProduct = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        videosRv.apply {
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
            videosRv.addItemDecoration(itemDecoration)
            layoutManager = vmProduct
            adapter = callsAdapter

        }
    }
    fun dialogshow() {
        val dialog = VideoDetailDialog(requireContext())

        dialog.setTargetFragment(this, 1)
        fragmentManager?.let { it1 -> dialog.show(it1, "AdresseDialog") }
    }


}