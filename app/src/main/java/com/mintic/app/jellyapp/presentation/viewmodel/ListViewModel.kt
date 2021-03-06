package com.mintic.app.jellyapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mintic.app.jellyapp.model.City
import com.mintic.app.jellyapp.remote.RetrofitFactory
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private var apiService = RetrofitFactory.apiService()
    private var cityList = MutableLiveData<List<City>>()
    private var isFailure = MutableLiveData(false)

    init{
        requestCityFromService()
    }

    fun getIsFailure(): LiveData<Boolean> = isFailure

    fun getCitys(): LiveData<List<City>> = cityList

    private fun requestCityFromService(){
        viewModelScope.launch{
            cityList.value = apiService.requestCity()
        }

    }

}
