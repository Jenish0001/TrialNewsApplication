package com.example.trialnewsapplication.fragment

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.trialnewsapplication.Adpter.My_Categery_Adpter
import com.example.trialnewsapplication.Adpter.TabView_Adpter
import com.example.trialnewsapplication.activity.MainActivity
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.view.ArticlesItem
import com.google.android.material.tabs.TabLayout

class Home_Fragment(val mainActivity: MainActivity) : Fragment() {

    lateinit var tab_view: TabLayout
    lateinit var pager_view: ViewPager
    lateinit var serch_Img: ImageView
    lateinit var categary_Img: ImageView

    var list = listOf<ArticlesItem>()

    var contryname = arrayOf(
        "ar",
        "gr",
        "nl",
        "za",
        "au",
        "hk",
        "nz",
        "kr",
        "at",
        "hu",
//        "ng",
//        "se",
//        "be",
//        "in",
//        "no",
//        "ch",
//        "br",
//        "id",
//        "ph",
//        "tw",
//        "bg",
//        "ie",
//        "pl",
//        "th",
//        "ca",
//        "il",
//        "pt",
//        "tr",
//        "cn",
//        "it",
//        "ro",
//        "ae",
//        "co",
//        "jp",
//        "ru",
//        "ua",
//        "cu",
//        "lv",
//        "sa",
//        "uk",
//        "cz",
//        "lt",
//        "rs",
//        "us",
//        "eg",
//        "my",
//        "sg"
        "in",
        "uk",
        "us"

    )

    var name = arrayOf(
        "Argentina",
        "Greece",
        "Netherlands",
        "South Africa",
        "Australia",
        "Hong Kong",
        "New Zealand",
        "South Korea",
        "Austria",
        "Hungary",
        "India",
        "United Kingdom",
        "United States"

    )


    lateinit var rvview: RecyclerView
    lateinit var ok_btn: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_home_, container, false)
        tab_view = view.findViewById<TabLayout>(R.id.tab_view)
        pager_view = view.findViewById<ViewPager>(R.id.pager_view)
        categary_Img = view.findViewById<ImageView>(R.id.categary_Img)
        serch_Img = view.findViewById<ImageView>(R.id.serch_Img)

        tabview()

        categary_Img.setOnClickListener {

            dialogCategary()

        }

        return view

    }

    private fun dialogCategary() {

        var dialog = Dialog(mainActivity)
        dialog.setContentView(R.layout.categry_filter_item)
        dialog.show()

        rvview = dialog.findViewById<RecyclerView>(R.id.rvview)
        ok_btn = dialog.findViewById<Button>(R.id.ok_btn)

        rvSetUp()

        ok_btn.setOnClickListener {

            tab()
            dialog.dismiss()


        }


    }

    fun rvSetUp() {

        var myca = My_Categery_Adpter(mainActivity, contryname)
        var lm = GridLayoutManager(mainActivity, 3)
        rvview.adapter = myca
        rvview.layoutManager = lm

    }

    fun tabview() {
        tab_view.addTab(tab_view.newTab().setText("business"))
        tab_view.addTab(tab_view.newTab().setText("Science"))
        tab_view.addTab(tab_view.newTab().setText("sport"))
        tab_view.addTab(tab_view.newTab().setText("technology"))
        tab_view.addTab(tab_view.newTab().setText("health"))
//        tab_view.addTab(tab_view.newTab().setText("technology"))
//        tab_view.addTab(tab_view.newTab().setText("Bitcoin"))

        tab()

    }

    private fun tab() {


        var adpter = TabView_Adpter(mainActivity, mainActivity.supportFragmentManager)
        pager_view.adapter = adpter

        pager_view.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_view))

        tab_view.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                pager_view.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }

    override fun onResume() {

        Handler().postDelayed(Runnable {
            var adpter = TabView_Adpter(mainActivity, mainActivity.supportFragmentManager)
            pager_view.adapter = adpter
        }, 1000)
        super.onResume()

    }

}


//  second key API       4f45340b45244521ac650281cb817bbe
// FIrst  key API        9e41272f5ec1439c9a0692b57ca606ba
//  thrid key API        89f86dad7f9a44ceb88bb6409b26a770
//        262A35
//        191A1F