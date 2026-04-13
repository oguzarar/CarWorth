package com.example.halisaham.uix.utils

sealed class Resource<out T> {
    data class Succes<out T>(val data:T): Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}