package com.example.myapplication_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        //region init
        var returnLogIn = findViewById<Button>(R.id.arrow_back)
        var registerBtn = findViewById<Button>(R.id.buttonRegister)

        var name = findViewById<EditText>(R.id.NameEditText)
        var secondName = findViewById<EditText>(R.id.SecondNameE)
        var DNI = findViewById<EditText>(R.id.DNIEditText)
        var password = findViewById<EditText>(R.id.PasswordEditText)
        //endregion
        returnLogIn.setOnClickListener {
            finish()
        }
        registerBtn.setOnClickListener {
            db.collection("Usuarios").document().set(
                hashMapOf(
                    "DNI" to DNI.text.toString(),
                    "Name" to name.text.toString(),
                    "Password" to password.text.toString(),
                    "SecondName" to secondName.text.toString()
                )
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    println("Firestore")
                } else {
                    val exception = task.exception
                    if (exception != null) {
                        println("Firestore")
                    }
                }
            }
        }
    }
    private fun isDatabaseConnected(): Boolean {
        try {
            db.collection("Usuarios").document("Users").get()
            return true
        } catch (e: Exception) {
            return false
        }
    }
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en la conexión a la base de datos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
