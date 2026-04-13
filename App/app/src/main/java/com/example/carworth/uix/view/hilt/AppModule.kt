package com.example.portfoy.hilt

import com.example.halisaham.data.retrofit.ApiUtils
import com.example.halisaham.data.retrofit.ArabaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesCoinDao(): ArabaDao{
        return ApiUtils.getPrice()
    }
}