package com.example.trialnewsapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.trialnewsapplication.R
import com.google.firebase.auth.FirebaseAuth

class splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        var firebaseAuth = FirebaseAuth.getInstance()
        var user = firebaseAuth.currentUser

        Handler().postDelayed({
            if (user != null) {

                var i = Intent(this, MainActivity::class.java)
                startActivity(i)

            } else {
                var i = Intent(this, LogInScreen::class.java)
                startActivity(i)
            }

            finish()
        }, 5000)

    }

}