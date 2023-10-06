package com.example.myapplication_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        var returnLogIn = findViewById<Button>(R.id.arrow_back)
        var registerBtn = findViewById<Button>(R.id.buttonRegister)

        var name = findViewById<EditText>(R.id.NameEditText)
        var secondName = findViewById<EditText>(R.id.SecondNameE)
        var DNI = findViewById<EditText>(R.id.DNIEditText)
        var password = findViewById<EditText>(R.id.PasswordEditText)
        returnLogIn.setOnClickListener {
            finish()
        }

        registerBtn.setOnClickListener{
            db.collection("Usuarios").document("users12").set(
                hashMapOf(
                    "DNI" to DNI.text.toString(),
                    "Name" to name.text.toString(),
                    "Password" to password.text.toString(),
                    "SecondName" to secondName.text.toString(),
                )
            )
        }
    }




}
