package com.example.coffeecraft.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.coffeecraft.data.CoffeeDataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    // 1. Ambil data dari DataSource yang kita buat di Hari 2
    val coffees = CoffeeDataSource.dummyCoffees

    // 2. Scaffold adalah struktur dasar layar (menyediakan slot untuk TopBar, Content, dll)
    Scaffold(
        modifier = modifier, // Menambahkan koma di sini
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "CoffeeCraft",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer, // Warna background header
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer // Warna teks header
                )
            )
        }
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