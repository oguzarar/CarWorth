package com.example.carworth.uix.view.data.retrofit

import com.example.carworth.uix.view.fonk.Araba
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ArabaDao {

    @POST("araba")
    suspend fun getPrice(@Body araba: Araba): Double


}