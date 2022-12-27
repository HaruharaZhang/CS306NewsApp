package com.example.finalproject_plus.verification

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Authorization {
    private var auth = FirebaseAuth.getInstance()
    private var currentUser = auth.currentUser

    //true -> user already login
    //false -> user not login yet
    fun getUserStatus(): Boolean {
        return currentUser != null
    }
    fun getUser(): FirebaseUser?{
        return currentUser
    }
    fun setUser(user: FirebaseUser?){
        if(user != null){
            currentUser = user
        }
    }
    fun getUserEmail(): String? {
        return currentUser?.email
    }
    fun logout(){
        if(currentUser != null) {
            auth.signOut()
            currentUser = auth.currentUser
        }
    }
}