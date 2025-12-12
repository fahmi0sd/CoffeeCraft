package com.example.coffeecraft.data

import androidx.annotation.DrawableRes

// Data class adalah fitur Kotlin untuk menyimpan data tanpa boilerplate code
data class Coffee(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    @DrawableRes val imageRes: Int, // Anotasi ini memastikan kita hanya memasukkan ID gambar yang valid
    val rating: Double
)