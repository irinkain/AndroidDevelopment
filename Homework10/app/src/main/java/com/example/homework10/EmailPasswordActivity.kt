package com.example.homework10.com.example.homework10

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.firebase.ui.auth.AuthUI.getApplicationContext
import com.google.firebase.auth.FirebaseAuth

public class EmailPasswordActivity()

private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
@SuppressLint("RestrictedApi")
fun createAccount(email: String, password: String) {
    mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener {
            if(it.isSuccessful) {
                Log.d(TAG, "createUserWithEmail:success")
                Toast.makeText(getApplicationContext(), "მომხმარებელი წარმატებით შეიქმნა", Toast.LENGTH_SHORT).show()
            } else {
                Log.w(TAG, "createUserWithEmail:failure")
                Toast.makeText(getApplicationContext(), "მომხმარებელის შექმნა ვერ მოხერხდა", Toast.LENGTH_SHORT).show()
            }
        }

}