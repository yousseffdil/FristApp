package com.example.myapplication_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        var returnLogIn = findViewById<Button>(R.id.arrow_back)

        returnLogIn.setOnClickListener {
            finish()
        }
    }
}
