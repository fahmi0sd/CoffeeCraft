package com.example.coffeecraft.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.* // Menggunakan Material 3
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.coffeecraft.data.Coffee
import java.text.NumberFormat
import java.util.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeecraft.R
import androidx.compose.ui.res.painterResource

@Composable
fun CoffeeCard(
    coffee: Coffee, // Menerima data kopi sebagai parameter
    modifier: Modifier = Modifier,
    onItemClick: (Coffee) -> Unit
) {
    // Card adalah pembungkus dengan bayangan dan sudut membulat
    Card(
        modifier = modifier
            .padding(8.dp) // Jarak antar kartu
            .fillMaxWidth()
            .clickable { onItemClick(coffee) }, // Tambahkan ini agar card bisa diklik
        shape = RoundedCornerShape(16.dp), // Sudut membulat 16dp
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Efek bayangan
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant, // Warna background kartu
        )
    ) {
        Column {
            // 1. Gambar Kopi
            // AsyncImage adalah komponen dari library Coil untuk load gambar
            AsyncImage(
                model = coffee.imageRes,
                contentDescription = coffee.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),

                // TAMBAHAN PENTING UNTUK PREVIEW:
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background),
                fallback = painterResource(id = R.drawable.ic_launcher_background)
            )

            // 2. Informasi Text (Nama & Harga)
            Column(
                modifier = Modifier.padding(12.dp) // Padding di dalam teks
            ) {
                // Nama Kopi
                Text(
                    text = coffee.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1 // Jika nama terlalu panjang, potong
                )

                Spacer(modifier = Modifier.height(4.dp)) // Jarak kecil

                // Harga (Diformat ke Rupiah)
                val formattedPrice =
                    NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"))
                        .format(coffee.price)
                Text(
                    text = formattedPrice,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeCardPreview() {
    // Membuat data pura-pura hanya untuk preview
    val sampleCoffee = Coffee(
        id = 1,
        name = "Espresso",
        description = "Test description",
        price = 25000.0,
        imageRes = R.drawable.espresso, // Pastikan gambar ini ada, atau ganti dengan R.drawable.ic_launcher_background jika error
        rating = 4.5
    )

    CoffeeCard(coffee = sampleCoffee, onItemClick = {})
}