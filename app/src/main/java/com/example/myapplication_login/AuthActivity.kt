package com.example.myapplication_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region init
        val btnOpenSignUp = findViewById<Button>(R.id.buttonRegister)

        //endregion
        btnOpenSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //setup()
        setup()
    }

    private fun setup() {
        title = "Autenticación"
        val buttonLogin = findViewById<Button>(R.id.buttonLogIn)
        val EmailEditText = findViewById<EditText>(R.id.EmailEditText)
        val PasswordEditText = findViewById<EditText>(R.id.PasswordEditText)

        buttonLogin.setOnClickListener {
            if (!EmailEditText.text.isEmpty() && !PasswordEditText.text.isEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    EmailEditText.text.toString(),
                    PasswordEditText.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainApp::class.java)
                        startActivity(intent)
                    } else {
                        showAlert()
                    }
                }
            }else{
                showAlert()
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en la autenticación del usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
