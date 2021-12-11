package com.mintic.app.jellyapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlin.properties.Delegates


class CityDescriptionFragment : Fragment() {

    private lateinit var contexto: Context
    private lateinit var cityName : String
    private lateinit var cityTemp : String
    private lateinit var cityDescription : String
    private lateinit var cityLocation : String
    private lateinit var cityImageUrl : String
    private lateinit var cityGeoLat : String
    private lateinit var cityGeoLon : String
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

        cityName = args.cityName
        cityTemp = args.temperature
        cityDescription = args.cityDescription
        cityLocation = args.cityLocation
        cityImageUrl = args.imgUrl
        cityRating = args.ratingValue
        cityGeoLat = args.geoLat
        cityGeoLon = args.geoLon
        updateDisplay(view)

        val buttonMap = view.findViewById<ImageButton>(R.id.imageButton)
        buttonMap.setOnClickListener(){
            launchMap(cityGeoLat,cityGeoLon,)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }

    private fun launchMap(lat:String,lon:String){
        val gmmIntentUri = Uri.parse("geo:$lat,$lon")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
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