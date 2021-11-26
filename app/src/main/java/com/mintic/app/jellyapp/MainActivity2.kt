package com.mintic.app.jellyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
//import com.mintic.app.jellyapp.MainActivity.Companion.CITY_NAME
//import com.mintic.app.jellyapp.MainActivity.Companion.CITY_TEMP
//import com.mintic.app.jellyapp.MainActivity.Companion.CITY_DESCRIPTION
//import com.mintic.app.jellyapp.MainActivity.Companion.CITY_IMAGE
//import com.mintic.app.jellyapp.MainActivity.Companion.CITY_LOCATION
//import com.mintic.app.jellyapp.MainActivity.Companion.CITY_RATING


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_city_details)



//        val cityName = intent.getStringExtra(CITY_NAME)
//        val cityTemp = intent.getStringExtra(CITY_TEMP)
//        val cityDescription = intent.getStringExtra(CITY_DESCRIPTION)
//        val cityLocation = intent.getStringExtra(CITY_LOCATION)
//        val cityImageUrl = intent.getStringExtra(CITY_IMAGE)
//        val cityRating = intent.getStringExtra(CITY_RATING)

        val cityName = "intent.getStringExtra(CITY_NAME)"
        val cityTemp = "intent.getStringExtra(CITY_TEMP)"
        val cityDescription = "intent.getStringExtra(CITY_DESCRIPTION)"
        val cityLocation = "intent.getStringExtra(CITY_LOCATION)"
        val cityImageUrl = "intent.getStringExtra(CITY_IMAGE)"
        val cityRating = "intent.getStringExtra(CITY_RATING)"


        val textViewTitle = findViewById<TextView>(R.id.cityName).apply {
            text = cityName
        }

        val textViewTemp = findViewById<TextView>(R.id.TextTemperatura).apply {
            text = cityTemp
        }

        val textViewLocation = findViewById<TextView>(R.id.TextUbicacion).apply {
            text = cityLocation
        }

        val textViewDescription = findViewById<TextView>(R.id.TextDescription).apply {
            text = cityDescription
        }

        val ratingCityValue = findViewById<RatingBar>(R.id.ratingBar2).apply {
            rating = cityRating?.toFloat() ?: 0F
        }




        val imageView = findViewById<ImageView>(R.id.imageView);
        Glide.with(this).load(cityImageUrl).into(imageView)








    }
}