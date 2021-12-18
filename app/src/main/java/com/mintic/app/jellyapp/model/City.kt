package com.mintic.app.jellyapp.model;

import com.google.gson.annotations.SerializedName

data class City (
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
