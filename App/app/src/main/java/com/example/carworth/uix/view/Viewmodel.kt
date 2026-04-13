package com.example.carworth.uix.view

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carworth.uix.view.data.retrofit.DataSource
import com.example.carworth.uix.view.data.retrofit.Resource
import com.example.carworth.uix.view.fonk.Araba
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(
    private val data: DataSource
) : ViewModel(){

    private val _price = mutableStateOf<Resource<Double>>(Resource.Loading)

    val price : State<Resource<Double>> = _price

    fun getPrice(araba: Araba){
        viewModelScope.launch {
            data.getPrice(araba).collect { resource ->
                _price.value = resource
            }
        }
    }
}