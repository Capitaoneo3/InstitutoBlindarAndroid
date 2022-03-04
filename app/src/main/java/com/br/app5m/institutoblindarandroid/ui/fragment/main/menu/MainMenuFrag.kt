package com.br.app5m.institutoblindarandroid.ui.fragment.main.menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.ui.activity.StartActivity
import kotlinx.android.synthetic.main.fragment_main_menu.*


class MainMenuFrag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileCl.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFrag_to_profileFrag)
        }
        closeCl.setOnClickListener {
            requireActivity().finishAffinity()
            activity?.let {
                val intent = Intent(it, StartActivity::class.java)
                it.startActivity(intent)
                it.finishAffinity()
            }
        }
    }


}