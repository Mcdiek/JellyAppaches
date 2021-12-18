package com.mintic.app.jellyapp.remote

import com.mintic.app.jellyapp.model.City
import retrofit2.http.GET

interface ApiService {
    @GET("cities")

    suspend fun requestCity() : List<City>
}