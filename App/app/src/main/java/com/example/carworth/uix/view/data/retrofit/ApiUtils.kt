package com.example.halisaham.data.retrofit

class ApiUtils {

    companion object{
        val url = "https://carworth-vhir.onrender.com/"

        fun getPrice(): ArabaDao{
            return RetrofitClient.getClient(url).create(ArabaDao::class.java)
        }

    }
}