package com.example.amphibiansapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class that defines the information of the amphibian.
 * It consists of the name, the type, the description and the image.
 */
@Serializable
data class AmphibiansInformation(
    val name: String,
    val type: String,
    val description: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)