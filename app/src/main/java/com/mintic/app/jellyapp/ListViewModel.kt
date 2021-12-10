package com.mintic.app.jellyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private var apiService = RetrofitFactory.apiService()
    private var cityList = MutableLiveData<List<City>>()

    init{
        requestCityFromService()
    }

    fun getCitys(): LiveData<List<City>> = cityList

//    private fun requestCity(){
//        var list = listOf<City>(
//            City("Tunja","Boyaca","20","www.google.com","Hola city","5"),
//            City("Bogota","Cundinamarca","20","www.google.com","Hola city","5")
//        )
//        cityList.value = list
//    }

    private fun requestCityFromService(){
        viewModelScope.launch{
            cityList.value = apiService.requestCity()
        }

    }

}
