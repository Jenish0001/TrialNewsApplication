package com.example.trialnewsapplication.logscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.activity.LogInScreen
import com.google.android.material.textfield.TextInputEditText

class LogOutScreen : AppCompatActivity() {

    lateinit var emailRegister: TextInputEditText
    lateinit var passwordRegister: TextInputEditText
    lateinit var moblieRegister: TextInputEditText
    lateinit var confirmRegister: TextInputEditText
    lateinit var submit_Btn: Button
    lateinit var login_txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_log_out_screen)

        blinding()


    }

    fun blinding() {
        emailRegister = findViewById<TextInputEditText>(R.id.emailRegister)
        passwordRegister = findViewById<TextInputEditText>(R.id.passwordRegister)
        confirmRegister = findViewById<TextInputEditText>(R.id.confirmRegister)
        moblieRegister = findViewById<TextInputEditText>(R.id.moblieRegister)
        submit_Btn = findViewById<Button>(R.id.submit_Btn)
        login_txt = findViewById<TextView>(R.id.login_txt)


        submit_Btn.setOnClickListener {

            var i = Intent(this, LogInScreen::class.java)
            startActivity(i)

        }
    }
}