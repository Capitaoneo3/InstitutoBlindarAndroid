package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.audios

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.app5m.institutoblindarandroid.R

class AudiosFrag : Fragment() {

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
        // TODO: Use the ViewModel
    }

}