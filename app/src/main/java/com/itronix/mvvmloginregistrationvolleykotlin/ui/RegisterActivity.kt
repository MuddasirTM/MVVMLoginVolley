package com.itronix.mvvmloginregistrationvolleykotlin.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.itronix.mvvmloginregistrationvolleykotlin.databinding.ActivityRegisterBinding
import com.itronix.mvvmloginregistrationvolleykotlin.viewmodel.AuthViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.authResponse.observe(this) { response ->
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            if (response.contains("success", ignoreCase = true)) {
                finish() // Go back to Login on success
            }
        }

        binding.registerBtn.setOnClickListener {
            val email = binding.emailInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.register(email, password)
            }
        }
    }
}