package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btnSignup.setOnClickListener {
            var firstName=etFirstName.text.toString()
            var lastName=etLastName.text.toString()
            val email=etEmail.text.toString()
            var phoneNumber=etPhoneNumber.text.toString()
            var password=etPassword.text.toString()
            var confirmPassword=etConfirmPassword.text.toString()
            Toast.makeText(baseContext,lastName,Toast.LENGTH_LONG).show()
        }

        }
    }
