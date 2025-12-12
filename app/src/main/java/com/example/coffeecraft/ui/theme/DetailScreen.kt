package com.example.coffeecraft.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.coffeecraft.R
import com.example.coffeecraft.data.CoffeeDataSource
import java.text.NumberFormat
import java.util.Locale

@Composable
fun DetailScreen(
    coffeeId: Long,
    modifier: Modifier = Modifier
) {
    // 1. Cari data kopi berdasarkan ID
    // Logika sederhana: Cari di list, kalau tidak ketemu ambil yang pertama (safety)
    val coffee = CoffeeDataSource.dummyCoffees.find { it.id == coffeeId }
        ?: CoffeeDataSource.dummyCoffees.first()

    // 2. State untuk scrolling
    val scrollState = rememberScrollState()

    Box(modifier = modifier.fillMaxSize()) {
        // Konten yang bisa di-scroll
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState) // Mengaktifkan scroll
                .padding(bottom = 80.dp) // Memberi ruang untuk tombol di bawah
        ) {
            // A. Gambar Header Besar
            AsyncImage(
                model = coffee.imageRes,
                contentDescription = coffee.name,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp) // Gambar besar agar terlihat mewah
            )

            // B. Detail Teks
            Column(modifier = Modifier.padding(24.dp)) {
                // Nama Kopi
                Text(
                    text = coffee.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Harga
                val formattedPrice = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID")).format(coffee.price)
                Text(
                    text = formattedPrice,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(16.dp))

                HorizontalDivider() // Garis pemisah tipis

                Spacer(modifier = Modifier.height(16.dp))

                // Deskripsi Title
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Deskripsi Body
                Text(
                    text = coffee.description,
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 24.sp // Jarak antar baris agar mudah dibaca
                )
            }
        }

        // C. Tombol Order (Melayang di bawah)
        Button(
            onClick = { /* Nanti diisi logika order */ },
            modifier = Modifier
                .align(Alignment.BottomCenter) // Tempel di bawah tengah
                .padding(16.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Order Now", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    // Kita panggil DetailScreen dengan ID sembarang (misal 1)
    DetailScreen(coffeeId = 1)
}