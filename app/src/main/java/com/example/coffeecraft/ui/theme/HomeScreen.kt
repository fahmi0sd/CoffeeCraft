package com.example.coffeecraft.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coffeecraft.data.CoffeeDataSource

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    // 1. Ambil data dari DataSource yang kita buat di Hari 2
    val coffees = CoffeeDataSource.dummyCoffees

    // 2. Scaffold adalah struktur dasar layar (menyediakan slot untuk TopBar, Content, dll)
    // Kita akan menambahkan TopBar di Hari 5, jadi sekarang biarkan kosong dulu.
    Scaffold(
        modifier = modifier
    ) { innerPadding ->

        // 3. LazyVerticalGrid = RecyclerView versi Compose
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Menentukan jumlah kolom (2 kolom)
            contentPadding = PaddingValues(16.dp), // Jarak di pinggir layar
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Jarak antar kartu (kiri-kanan)
            verticalArrangement = Arrangement.spacedBy(16.dp), // Jarak antar kartu (atas-bawah)
            modifier = Modifier.padding(innerPadding) // Penting! Padding dari Scaffold agar konten tidak tertutup status bar
        ) {
            // 4. Memasukkan item ke dalam grid
            items(
                items = coffees,
                key = { it.id } // Key unik membantu performa render (penting untuk profesional code)
            ) { coffee ->
                CoffeeCard(coffee = coffee)
            }
        }
    }
}