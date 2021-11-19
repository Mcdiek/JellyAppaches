package com.mintic.app.jellyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.mintic.app.jellyapp.MainActivity.Companion.CITY_MESSAGE

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_spots)

        val message = intent.getStringExtra(CITY_MESSAGE)


        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }






    }
}