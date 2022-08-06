package com.example.trialnewsapplication.Adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.trialnewsapplication.MainActivity
import com.example.trialnewsapplication.tabFragmant.Business_Fragment
import com.example.trialnewsapplication.tabFragmant.Science_Fragment
import com.example.trialnewsapplication.tabFragmant.Tecnology_Fragment
import com.example.trialnewsapplication.tabFragmant.sport_Fragment

class TabView_Adpter(val homeFragment: MainActivity, supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {

            0 ->Business_Fragment(homeFragment)

            1 ->Science_Fragment(homeFragment)

            2 -> sport_Fragment(homeFragment)

            else -> Tecnology_Fragment(homeFragment)


        }

    }

}