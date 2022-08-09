package com.example.trialnewsapplication.logscreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.activity.MainActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.util.*

class LogOutScreen : AppCompatActivity() {

    lateinit var loginButton: LoginButton
    private val EMAIL = "email"
    private val RC_SIGN_IN = 1
    lateinit var googleCvImg: CardView
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

        checksamepassword()

        googleLOgin()

        facebookLoginRegister()

    }
//  Facebook Login with Regester ======
    private fun facebookLoginRegister() {

    var callbackManager = CallbackManager.Factory.create()

    loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
        override fun onCancel() {

        }

        override fun onError(error: FacebookException) {

        }

        override fun onSuccess(result: LoginResult) {
            firebaseLogin(result.accessToken.token)
        }
    })

    }

    private fun firebaseLogin(token: String) {

        var cmd = FacebookAuthProvider.getCredential(token)
        var firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signInWithCredential(cmd).addOnSuccessListener { res ->
            var int = Intent(this, MainActivity::class.java)
            startActivity(int)
            Log.e("TAG", "firefblogin: $res")

        }.addOnFailureListener { error ->
            Log.e("TAG", "firefblogin: ${error.message}")

        }

    }

    // Google login =======
    private fun googleLOgin() {

        googleCvImg.setOnClickListener {

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString((R.string.client)))
                .requestEmail()
                .build()
            var googleApiClient = GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()

            val intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
            startActivityForResult(intent, RC_SIGN_IN)


        }

    }
//    goole on activityResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            RC_SIGN_IN -> {

//                old code==========================

                val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data!!)
                var account = result?.signInAccount
                loginwithCredantail(account?.idToken.toString())

            }

        }
    }

    private fun loginwithCredantail(token: String) {

        val crd = GoogleAuthProvider.getCredential(token, null)

        var firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signInWithCredential(crd).addOnSuccessListener { res ->

            var i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }.addOnFailureListener { error ->

            Log.e("TAG", "loginwithCredantail: ${error.message}")

        }

    }

    //  check for pass word and confirm password  register page=======
    private fun checksamepassword() {

        var pass = passwordRegister.text.toString()
        var conf = confirmRegister.text.toString()

//        googleCvImg.setOnClickListener {
//
//            if (pass == conf) {
//
//                Toast.makeText(this, "Both are same", Toast.LENGTH_SHORT).show()
//
//                confirmRegister.setTextColor(getResources().getColor(R.color.gray))
//
//            } else if(pass!=conf) {
//                confirmRegister.setTextColor(getResources().getColor(R.color.purple_500))
//
//                Toast.makeText(this, "not same", Toast.LENGTH_SHORT).show()
//            }
//
//
//        }

    }

    //    normal sign in=======
    private fun normalsign(email: String, password: String) {

        var firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener { res ->
            Toast.makeText(this, "sucees email", Toast.LENGTH_SHORT).show()

            var i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }
            .addOnFailureListener { error ->
                Log.e("TAG", "normalsign: ${error.message}")
            }

    }


    fun blinding() {
        emailRegister = findViewById<TextInputEditText>(R.id.emailRegister)
        passwordRegister = findViewById<TextInputEditText>(R.id.passwordRegister)
        confirmRegister = findViewById<TextInputEditText>(R.id.confirmRegister)
        moblieRegister = findViewById<TextInputEditText>(R.id.moblieRegister)
        submit_Btn = findViewById<Button>(R.id.submit_Btn)
        login_txt = findViewById<TextView>(R.id.login_txt)
        googleCvImg = findViewById<CardView>(R.id.googleCvImg)

        loginButton = findViewById<LoginButton>(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        submit_Btn.setOnClickListener {

            normalsign(emailRegister.text.toString(), passwordRegister.text.toString())
        }
    }

}
