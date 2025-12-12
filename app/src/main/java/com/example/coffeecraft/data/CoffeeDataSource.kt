package com.example.coffeecraft.data

import com.example.coffeecraft.R // Pastikan R di-import dari package aplikasi Anda

object CoffeeDataSource {
    val dummyCoffees = listOf(
        Coffee(
            id = 1,
            name = "Espresso",
            description = "Espresso adalah minuman kopi pekat yang diseduh dengan memaksa sejumlah kecil air mendidih di bawah tekanan melalui biji kopi yang digiling halus. Rasanya kuat dan kaya.",
            price = 25000.0,
            imageRes = R.drawable.espresso, // Pastikan ada file espresso.jpg/png di folder drawable
            rating = 4.5
        ),
        Coffee(
            id = 2,
            name = "Cappuccino",
            description = "Minuman kopi asal Italia yang secara tradisional disiapkan dengan espresso, susu panas, dan busa susu kukus. Teksturnya creamy dan lembut.",
            price = 30000.0,
            imageRes = R.drawable.cappuccino, // Sesuaikan nama file
            rating = 4.8
        ),
        Coffee(
            id = 3,
            name = "Latte Macchiato",
            description = "Latte macchiato adalah minuman kopi susu yang namanya berarti 'susu bernoda'. Minuman ini ditandai dengan tanda espresso di atas susu.",
            price = 32000.0,
            imageRes = R.drawable.latte_art, // Sesuaikan nama file
            rating = 4.7
        )
    )
}