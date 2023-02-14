package com.example.amphibiansapp.ui.screens

import com.example.amphibiansapp.model.AmphibiansInformation

/**
 * UI State for HomeScreen
 */
sealed interface AmphibiansUiState {
    data class Success(val info: List<AmphibiansInformation>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}