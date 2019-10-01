package com.example.fragmentgame.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentgame.R


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //hide the status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        Thread(Runnable {
            try {
                Thread.sleep(1000)
                    startActivity(Intent(this, MainActivity::class.java))
                finish()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }).start()
    }
}
