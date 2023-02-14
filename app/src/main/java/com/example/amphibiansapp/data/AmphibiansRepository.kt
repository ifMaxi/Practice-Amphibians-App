package com.example.amphibiansapp.data

import com.example.amphibiansapp.model.AmphibiansInformation
import com.example.amphibiansapp.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<AmphibiansInformation>
}

class AmphibiansImpl(
    private val amphibiansApiService: AmphibiansApiService): AmphibiansRepository {
    override suspend fun getAmphibians(): List<AmphibiansInformation> =
        amphibiansApiService.getInformation()
}