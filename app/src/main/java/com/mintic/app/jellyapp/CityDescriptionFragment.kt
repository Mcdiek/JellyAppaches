package com.mintic.app.jellyapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlin.properties.Delegates


class CityDescriptionFragment : Fragment() {

    private lateinit var cityName : String
    private lateinit var cityTemp : String
    private lateinit var cityDescription : String
    private lateinit var cityLocation : String
    private lateinit var cityImageUrl : String
    private var cityRating by Delegates.notNull<Float>()

    val args: CityDescriptionFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_city_description, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        cityNameView = view.findViewById(R.id.cityName)
//        cityTempView = view.findViewById(R.id.TextTemperatura)
//        cityLocationView = view.findViewById(R.id.TextUbicacion)
//        cityDescriptionView = view.findViewById(R.id.TextDescription)
//        cityImageUrlView = view.findViewById(R.id.imageView)
//        cityRatingView = view.findViewById(R.id.ratingBar2)


        cityName = args.cityName
        cityTemp = args.temperature
        cityDescription = args.cityDescription
        cityLocation = args.cityLocation
        cityImageUrl = args.imgUrl
        cityRating = args.ratingValue


        updateDisplay(view)

    }


    private fun updateDisplay(view: View) {

        val textViewTitle = view.findViewById<TextView>(R.id.cityName).apply {
            text = cityName
        }

        val textViewTemp = view.findViewById<TextView>(R.id.TextTemperatura).apply {
            text = cityTemp
        }

        val textViewLocation = view.findViewById<TextView>(R.id.TextUbicacion).apply {
            text = cityLocation
        }

        val textViewDescription = view.findViewById<TextView>(R.id.TextDescription).apply {
            text = cityDescription
        }

        val ratingCityValue = view.findViewById<RatingBar>(R.id.ratingBar2).apply {
            rating = cityRating
        }

        val imageView = view.findViewById<ImageView>(R.id.imageView);
        Glide.with(this).load(cityImageUrl).into(imageView)
    }






}