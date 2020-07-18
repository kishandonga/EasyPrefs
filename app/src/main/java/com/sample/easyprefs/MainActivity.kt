package com.sample.easyprefs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.easyprefs.Prefs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Prefs.write().stringSetAsync("", HashSet())
    }
}