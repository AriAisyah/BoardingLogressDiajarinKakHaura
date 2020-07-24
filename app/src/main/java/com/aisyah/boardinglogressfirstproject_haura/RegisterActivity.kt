package com.aisyah.boardinglogressfirstproject_haura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        itLogin.setOnClickListener {
            Intent(applicationContext,LoginActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        btnRegister.setOnClickListener {
            Intent(applicationContext,LoginActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}