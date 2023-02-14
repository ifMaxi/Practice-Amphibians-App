package com.example.amphibiansapp.network

import com.example.amphibiansapp.model.AmphibiansInformation
import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getInformation(): List<AmphibiansInformation>
}