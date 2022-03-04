package com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.br.app5m.institutoblindarandroid.R
import com.br.app5m.institutoblindarandroid.helper.ZoomOutPageTransformer
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.archives.ArchivesFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.audios.AudiosFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.detail.message.MessagesFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.finalized.FinalizedCallFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.inprogress.InProgressCallFrag
import com.br.app5m.institutoblindarandroid.ui.fragment.main.mycalls.pending.PendingCallFrag
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_my_calls.*

class DetailCallFrag : Fragment() {
    private lateinit var adapter: FragmentStateAdapter


    override fun onResume() {
        super.onResume()
        configInitialViews()

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_call_fragment, container, false)
    }





    private fun configInitialViews() {
        var positionVp = arguments?.getInt("positionVp")





        adapter = ScreenSlidePagerAdapter(activity)
        adapter.notifyDataSetChanged()
        if (isAdded){

            mPager.adapter = adapter
            mPager.setPageTransformer(ZoomOutPageTransformer())

            TabLayoutMediator(tabView, mPager) { tab: TabLayout.Tab, position: Int ->
                when (position) {
                    0 -> tab.text = "Mensagens"
                    1 -> tab.text = "Áudios"
                    2 -> tab.text = "Arquivos"


                }
            }.attach()
        }

        /* if (positionVp !=0){
             mPager.setCurrentItem(1, false)
         }*/
    }


    private class ScreenSlidePagerAdapter(fa: FragmentActivity?) :
        FragmentStateAdapter(fa!!) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> MessagesFrag()
                1 -> AudiosFrag()

                else -> {
                    ArchivesFrag()
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
