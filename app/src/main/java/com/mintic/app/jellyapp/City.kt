package com.mintic.app.jellyapp;

import com.google.gson.annotations.SerializedName

data class City (
        //En caso de que quiera poner una etiqueta diferente puedo usar los siguiente
        @SerializedName("cityName")
        val cityName: String,
        val depName: String,
        var temperature: String,
        var imageUrl: String,
        var cityDescription: String,
        var ratCityValue: String,
        var geoLat: String,
        var geoLon: String,
)
