package com.mintic.app.jellyapp

import retrofit2.http.GET

interface ApiService {
    @GET("cities")

    //El suspend se agrega para funcionar en una corutina
    suspend fun requestCity() : List<City>
}