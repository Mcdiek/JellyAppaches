package com.mintic.app.jellyapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_menu)
    }

    fun sendMessage(view: View) {
        Log.d("TAG", "Funciona")
        // Do something in response to button
    }


}