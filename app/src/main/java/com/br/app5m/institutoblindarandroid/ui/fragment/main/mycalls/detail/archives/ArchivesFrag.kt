package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.archives

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.app5m.institutoblindarandroid.R

class ArchivesFrag : Fragment() {

    companion object {
        fun newInstance() = ArchivesFrag()
    }

    private lateinit var viewModel: ArchivesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.archives_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArchivesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}