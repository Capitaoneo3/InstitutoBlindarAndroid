package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.archives.vizualizearchive

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.app5m.institutoblindarandroid.R
import kotlinx.android.synthetic.main.vizualize_archive_fragment.*

class VizualizeArchive : Fragment() {

    companion object {
        fun newInstance() = VizualizeArchive()
    }

    private lateinit var viewModel: VizualizeArchiveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vizualize_archive_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VizualizeArchiveViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pdfLink: String = "https://drive.google.com/file/d/1dsZd8HICIcuakeIwO7cEgcvKV9GzmOlI/view"

        @SuppressLint("SetJavaScriptEnabled")
        pdfView?.settings?.javaScriptEnabled = true

        pdfView?.loadUrl(pdfLink)
        pdfView?.settings?.builtInZoomControls = true

    }
}