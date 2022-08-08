package com.example.trialnewsapplication.activity

import  android.os.Bundle
import android.os.Handler
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.fragment.Home_Fragment
import com.example.trialnewsapplication.fragment.Second_Fragment
import com.example.trialnewsapplication.fragment.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var flFragment: FrameLayout
    lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flFragment = findViewById<FrameLayout>(R.id.flFragment)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val firstFragment = Home_Fragment(this)
        val secondFragment = Second_Fragment(this)
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.person -> setCurrentFragment(firstFragment)
                R.id.home -> setCurrentFragment(secondFragment)
                R.id.settings -> setCurrentFragment(thirdFragment)
            }
            true
        }
    }

    fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }



    override fun onResume() {
        Handler().postDelayed(Runnable {
            bottomNavigationView.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.person -> setCurrentFragment(Home_Fragment(this))
                    R.id.home -> setCurrentFragment(Second_Fragment(this))
                    R.id.settings -> setCurrentFragment(ThirdFragment())
                }
                true

            }

        }, 5000)
        super.onResume()

    }

}