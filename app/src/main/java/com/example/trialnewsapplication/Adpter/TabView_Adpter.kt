package com.example.trialnewsapplication.Adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.trialnewsapplication.activity.MainActivity
import com.example.trialnewsapplication.tabFragmant.*

class TabView_Adpter(val homeFragment: MainActivity, supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager) {
    override fun getCount(): Int {
        return 6
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {

            0 -> Business_Fragment(homeFragment)

            1 -> Science_Fragment(homeFragment)

            2 -> sport_Fragment(homeFragment)

            3 -> Tecnology_Fragment(homeFragment)
            4 -> Health_Fragment(homeFragment)

            else -> Entertainment_Fragment(homeFragment)


        }

    }

}