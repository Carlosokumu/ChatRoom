package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.chatapp.utils.makeStatusBarTransparent

@Suppress("DEPRECATION")
class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        makeStatusBarTransparent()
        Handler().postDelayed({
            startActivity(Intent(this@Splash,LeadActivity::class.java) )
            finish()
        },4000)
        //dialog.hide()

    }
}