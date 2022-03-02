package com.br.app5m.institutoblindarandroid.ui.fragment.Intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import br.com.app5m.chaveirosmania.ui.fragment.intro.IntroContainerViewModel
import com.br.app5m.institutoblindarandroid.R
import kotlinx.android.synthetic.main.fragment_container_intro.*


class IntroContainerFrag : Fragment() {
    private val introConViewModel: IntroContainerViewModel by viewModels()
//    private var preferences: Preferences? = null

    var savePosition: Int = 0


    val me: Fragment = this


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_container_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkFristOpen()
        configInitialViews()

    }

    private class SectionsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(
        fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    Intro1Frag()


                }
                else -> Intro2Frag()
            }
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 2
        }
    }

    private fun configInitialViews() {
        val adapter = fragmentManager?.let { SectionsPagerAdapter(it) }

        pagerView.adapter = adapter

        introIndicator.setViewPager(pagerView)

        pagerView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                if (position == 1) {
                    skip_intro_bt.visibility = View.VISIBLE
                    savePosition = position

                } else {
                    savePosition = position
                    skip_intro_bt.visibility = View.VISIBLE

                }
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        loadClicks()

    }
    private fun checkFristOpen(){
//        preferences = Preferences(requireContext())




/*        introConViewModel.fristOpen.observe(viewLifecycleOwner, Observer {
            if (IntroHelper.getInt(requireContext(), IntroHelper.ENTERING_FIRST_TIME, 1) === 1) {
//se for igual a 1 exibe a intro.
            }
            else{


                if (Preferences(requireContext()).getLogin()){
                    activity?.let{
                        val intent = Intent (it, MainActivity::class.java)
                        it.startActivity(intent)
                        it.finishAffinity()
                    }
                }else{
                    findNavController().navigate(R.id.action_containerIntroFrag_to_containerSiginInFrag)
                }
            }


        })*/
    }

    private fun loadClicks() {

        /*  skip_intro_bt.setOnClickListener {
              pagerView.currentItem++
          }*/
        skip_intro_bt.setOnClickListener {
            findNavController().navigate(R.id.action_introContainerFrag_to_loginFrag)

        }

    }

    override fun onResume() {
        super.onResume()
        pagerView.currentItem = savePosition

    }
}