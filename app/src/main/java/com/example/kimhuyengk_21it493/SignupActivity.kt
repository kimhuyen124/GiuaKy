package com.example.kimhuyengk_21it493

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    private lateinit var edtUsername: EditText
    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnSignup: Button

    private lateinit var userDatabase: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        edtUsername = findViewById(R.id.edtUsername)
        edtEmail  = findViewById(R.id.edtEmail)
       edtPassword = findViewById(R.id.edtPassword)
        btnSignup = findViewById(R.id.btnSignup)

        userDatabase = UserDatabase(this)

        btnSignup.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val email = edtEmail
                .text.toString().trim()
            val password = edtPassword
                .text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val result = userDatabase.addUser(username, email, password)
                if (result) {
                    Toast.makeText(this, "Signup success", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Signup failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
