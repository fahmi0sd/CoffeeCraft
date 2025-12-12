package com.example.coffeecraft.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(
    coffeeId: Long, // Halaman ini nanti butuh ID kopi untuk tahu data mana yang ditampilkan
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Ini adalah Halaman Detail untuk Kopi ID: $coffeeId")
    }
}