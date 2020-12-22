package com.yehia.mira_keyboard_utils.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.yehia.mira_keyboard_utils.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//
//        Handler(Looper.getMainLooper()).postDelayed({
//
//            val mainIntent= Intent(this, AuthActivity::class.java)
//            startActivity(mainIntent)
//            finish()
//
//        }, 3000)
    }

}