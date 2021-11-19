package com.mintic.app.jellyapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

private lateinit var mCity: ArrayList<City> //El lateinit sirve como promesa de que se inicializará la variable
private lateinit var mAdapter: CityAdapter
private lateinit var recycler: RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_menu)
    }





//    fun sendMessage(view: View) {
//        val textView = findViewById<TextView>(R.id.textCity1)
//        val message = textView.text.toString()
//        Log.d("TAG",message)
//        val intent = Intent(this, MainActivity2::class.java).apply {
//            putExtra(CITY_MESSAGE,message)
//        }
//        // intent.putExtra(ITY_MESSAGE,message)
//        startActivity(intent)
//    }
    companion object{
        const val CITY_MESSAGE = "com.mintic.app.jellyapp.MESSAGE"
    }


}