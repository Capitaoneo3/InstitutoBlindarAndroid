package com.br.app5m.institutoblindarandroid.ui.fragment.Intro.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.app5m.institutoblindarandroid.MainActivity
import com.br.app5m.institutoblindarandroid.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFrag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        okButton.setOnClickListener {
               activity?.let{
              val intent = Intent (it, MainActivity::class.java)
              it.startActivity(intent)
              it.finishAffinity()
          }
        }
    }

}