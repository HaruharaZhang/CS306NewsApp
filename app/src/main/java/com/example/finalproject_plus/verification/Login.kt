package com.example.finalproject_plus.verification

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject_plus.MainActivity
import com.example.finalproject_plus.R
import com.google.firebase.auth.FirebaseAuth
import java.math.RoundingMode.valueOf

class Login : AppCompatActivity(){
    lateinit var jumpIntent: Intent
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        var auth = FirebaseAuth.getInstance()

        val backBtn = findViewById<Button>(R.id.custom_back_btn)
        val loginBtn = findViewById<Button>(R.id.custom_save_btn)
        val email = findViewById<EditText>(R.id.register_user_email)
        val passwd = findViewById<EditText>(R.id.password)
        val loginError = findViewById<TextView>(R.id.nav_login_message)
        val registerBtn = findViewById<Button>(R.id.login_register_btn)

        backBtn.setOnClickListener() {
            loginError.text = ""
            when(intent.extras?.getString("name")){
                "MainActivity" -> {
                    jumpIntent = Intent(this, MainActivity::class.java)
                    startActivity(jumpIntent)
                }
                else -> {
                    jumpIntent = Intent(this, MainActivity::class.java)
                    startActivity(jumpIntent)
                }
            }
        }

        loginBtn.setOnClickListener(){
            loginError.text = ""
            if(email.text.isEmpty() || passwd.text.isEmpty()){
                loginError.setText(R.string.input_information)
            } else if(passwd.text.toString().length < 8) {
                loginError.setText(R.string.passwd_invalided)
            } else {
                auth.signInWithEmailAndPassword(email.text.toString(), passwd.text.toString()).addOnCompleteListener {
                        task ->
                    if(task.isSuccessful){
                        Authorization().setUser(auth.currentUser)
                        passwd.setText("")
                        jumpIntent = Intent(this, MainActivity::class.java)
                        startActivity(jumpIntent)
                    } else {
                        loginError.setText(R.string.passwd_no_match)
                    }
                }
            }
        }

        registerBtn.setOnClickListener(){
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}