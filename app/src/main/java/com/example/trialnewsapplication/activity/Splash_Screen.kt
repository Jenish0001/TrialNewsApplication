package com.example.trialnewsapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.trialnewsapplication.R
import com.google.firebase.auth.FirebaseAuth

class splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        var firebaseAuth = FirebaseAuth.getInstance()
        var user = firebaseAuth.currentUser

        var imgImg=findViewById<ImageView>(R.id.imgImg)

        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_item)
        imgImg.startAnimation(slideAnimation)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            if (user != null) {

                var i = Intent(this, MainActivity::class.java)
                startActivity(i)

            } else {
                var i = Intent(this, LogInScreen::class.java)
                startActivity(i)
            }

            finish()
        }, 1500)

    }

}