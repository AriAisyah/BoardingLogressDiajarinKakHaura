package com.aisyah.boardinglogressfirstproject_haura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        itRegister.setOnClickListener {
            Intent(applicationContext,RegisterActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        btnLogin.setOnClickListener {
            Intent(applicationContext,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}