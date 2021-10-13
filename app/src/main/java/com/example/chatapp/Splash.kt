package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.chatapp.Utils.makeStatusBarTransparent
import com.github.loadingview.LoadingDialog
import com.github.loadingview.LoadingView

@Suppress("DEPRECATION")
class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        makeStatusBarTransparent()
        val dialog = LoadingDialog[this].show()
        val loading=findViewById<LoadingView>(R.id.loadingView)
        loading.start()
        Handler().postDelayed({
            startActivity(Intent(this@Splash,EntryActivity::class.java) )
            loading.stop()
            finish()
        },4000)
        //dialog.hide()

    }
}