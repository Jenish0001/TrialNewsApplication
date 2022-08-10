package com.example.trialnewsapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.trialnewsapplication.databinding.ActivityLogInScreenBinding
import com.example.trialnewsapplication.logscreen.LogOutScreen
import com.google.firebase.auth.FirebaseAuth

class LogInScreen : AppCompatActivity() {
    lateinit var blinding: ActivityLogInScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_log_in_screen)

        blinding = ActivityLogInScreenBinding.inflate(layoutInflater)
        setContentView(blinding.root)

        signin()

    }

    //    normal signing on click method
    private fun signin() {

        blinding.signInBtn.setOnClickListener {

            normalsign(
                blinding.emailRegister.text.toString(),
                blinding.passwordRegister.text.toString()
            )
        }
        blinding.signUpTxt.setOnClickListener {

            var i=Intent(this,LogOutScreen::class.java)
            startActivity(i)

        }

    }

    //    normal sign in

    private fun normalsign(email: String, password: String) {

        var firebaseAuth= FirebaseAuth.getInstance()
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                res ->
            Toast.makeText(this, "sucees email", Toast.LENGTH_SHORT).show()

            var i=Intent(this,MainActivity::class.java)
            startActivity(i)

            finish()


        }

            .addOnFailureListener { error ->
                Log.e("TAG", "normalsign: ${error.message}")

                Toast.makeText(this, "enter correct password", Toast.LENGTH_SHORT).show()

            }


    }


}

