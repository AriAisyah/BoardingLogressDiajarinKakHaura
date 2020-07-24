package com.aisyah.boardinglogressfirstproject_haura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SS : AppCompatActivity() {

    private val splashTime = 3000 //3detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_s)

        Handler().postDelayed({
            Intent(applicationContext,OnBoardingActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }, splashTime.toLong())

    }
}