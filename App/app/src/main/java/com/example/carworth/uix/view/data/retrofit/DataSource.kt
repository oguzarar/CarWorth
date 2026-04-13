package com.example.carworth.uix.view.data.retrofit

import com.example.carworth.uix.view.fonk.Araba
import com.example.halisaham.data.retrofit.ArabaDao
import com.example.halisaham.uix.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DataSource @Inject constructor(
    private val arabaDao: ArabaDao
) {
    fun getPrice(araba: Araba): Flow<Resource<Double>> = flow {
        emit(Resource.Loading)
        try {
            val assets = arabaDao.getPrice(araba)
            emit(Resource.Succes(assets))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage ?: "Bağlantı Hatası"))
        }
    }.flowOn(Dispatchers.IO)

}