package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.ZoomOutPageTransformer
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.finalized.FinalizedCallFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.inprogress.InProgressCallFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.pending.PendingCallFrag
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_my_calls.*


class MyCallsFrag : Fragment() {
    private lateinit var adapter: FragmentStateAdapter





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_calls, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configInitialViews()

    }


    private fun configInitialViews() {
        var positionVp = arguments?.getInt("positionVp")





        adapter = ScreenSlidePagerAdapter(activity)
        adapter.notifyDataSetChanged()
        mPager.adapter = adapter

        mPager.setPageTransformer(ZoomOutPageTransformer())

        TabLayoutMediator(tabView, mPager) { tab: TabLayout.Tab, position: Int ->
            when (position) {
                0 -> tab.text = "Pendentes"
                1 -> tab.text = "Em Andamento"
                2 -> tab.text = "Finalizados"


            }
        }.attach()
       /* if (positionVp !=0){
            mPager.setCurrentItem(1, false)
        }*/
    }


    private class ScreenSlidePagerAdapter(fa: FragmentActivity?) :
        FragmentStateAdapter(fa!!) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> PendingCallFrag()
                1 -> InProgressCallFrag()

                else -> {
                    FinalizedCallFrag()
                }
            }


        }


        override fun getItemCount(): Int {
            return 3
        }

    }

  /*  fun dialogshowAtention(message: String) {
        val dialog = AtentionMessageDialog(message)

        dialog.setTargetFragment(this, 1)
        fragmentManager?.let { it1 -> dialog.show(it1, "BadMessageDialog") }
    }

    fun dialogshowRight(message: String) {
        val dialog = RightMessageDialog(message)

        dialog.setTargetFragment(this, 1)
        fragmentManager?.let { it1 -> dialog.show(it1, "BadMessageDialog") }
    }*/



}
