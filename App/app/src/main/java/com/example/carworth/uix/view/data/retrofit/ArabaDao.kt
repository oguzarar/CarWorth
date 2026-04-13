package com.example.halisaham.data.retrofit


import com.example.carworth.uix.view.fonk.Araba
import retrofit2.http.GET
import retrofit2.http.Query

interface ArabaDao {

    @GET("araba")
    suspend fun getPrice(@Query("araba") araba: Araba): Double


}