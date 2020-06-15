package com.example.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.homework10.com.example.homework10.EmailPasswordActivity
import com.example.homework10.com.example.homework10.createAccount

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textEmail = findViewById<View>(R.id.email) as EditText
        val email = textEmail.text.toString()
        val textPassword = findViewById<View>(R.id.email) as EditText
        val password = textPassword.text.toString()
        createAccount(email,password)
    }

}
