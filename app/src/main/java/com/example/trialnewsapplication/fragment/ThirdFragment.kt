package com.example.trialnewsapplication.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.activity.LogInScreen
import com.example.trialnewsapplication.activity.MainActivity
import com.google.firebase.auth.FirebaseAuth

class ThirdFragment(val mainActivity: MainActivity) : Fragment() {
    lateinit var logoutTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_third, container, false)

        logoutTextView = view.findViewById<TextView>(R.id.logoutTextView)
        logout()
        return view
    }


    //     Log out user=======
    private fun logout() {

        logoutTextView.setOnClickListener {

            var firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut()

            var i = Intent(mainActivity, LogInScreen::class.java)
            startActivity(i)

        }

    }


}