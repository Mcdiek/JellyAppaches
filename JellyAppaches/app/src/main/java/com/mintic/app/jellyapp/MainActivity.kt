package com.mintic.app.jellyapp

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_menu)
    }


    fun sendMessage(view: View) {

        val textView = findViewById<TextView>(R.id.textCity1)
        val message = textView.text.toString()
        Log.d("TAG",message)
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(CITY_MESSAGE,message)
        }

        startActivity(intent)
        // Do something in response to button
    }

    companion object{
        val CITY_MESSAGE = "com.mintic.app.jellyapp.MESSAGE"
    }


}