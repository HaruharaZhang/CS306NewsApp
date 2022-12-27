package com.example.finalproject_plus.verification

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject_plus.MainActivity
import com.example.finalproject_plus.R
import com.google.firebase.auth.FirebaseAuth


class Register : AppCompatActivity() {
    lateinit var jumpIntent: Intent
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        val backBtn = findViewById<Button>(R.id.register_back_btn)
        val email = findViewById<EditText>(R.id.register_user_email)
        val passwd = findViewById<EditText>(R.id.register_passwd)
        val passwdRe = findViewById<EditText>(R.id.register_passwd_re)
        val registerBtn = findViewById<Button>(R.id.register_btn)
        val errorMsg = findViewById<TextView>(R.id.register_err_msg)
        var auth = FirebaseAuth.getInstance()

        registerBtn.setOnClickListener(){
            if(isValidEmail(email.text.toString())){
                if(passwd.text.toString().length >= 8){
                    if(passwd.text.toString() == passwdRe.text.toString()){
                        auth.createUserWithEmailAndPassword(email.text.toString(),passwd.text.toString()).addOnCompleteListener {
                                task ->
                            if(task.isSuccessful){
                                Authorization().setUser(auth.currentUser)
                                email.setText("")
                                passwd.setText("")
                                passwdRe.setText("")

                                jumpIntent = Intent(this, MainActivity::class.java)
                                startActivity(jumpIntent)
                            } else {
                                errorMsg.text = "Cannot register with this email address, please try another one"
                            }
                        }
                    } else {
                        errorMsg.text = "The password and your repeat password is not a same one"
                    }
                } else {
                    errorMsg.text = "The length of password should larger than 8"
                }
            } else {
                errorMsg.text = "Invalid email format"
            }
        }

        backBtn.setOnClickListener(){
            finish()
        }
    }
    fun isValidEmail(email: CharSequence?): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}