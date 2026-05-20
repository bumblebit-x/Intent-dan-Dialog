package com.example.registrasiseminarcompose

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity  
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class HasilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nama = intent.getStringExtra("NAMA") ?: ""
        val nim = intent.getStringExtra("NIM") ?: ""
        val prodi = intent.getStringExtra("PRODI") ?: ""
        val email = intent.getStringExtra("EMAIL") ?: ""
        val telp = intent.getStringExtra("TELEPON") ?: ""

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HasilRegistrasiScreen(
                        nama = nama,
                        nim = nim,
                        prodi = prodi,
                        email = email,
                        telepon = telp,
                        onOpenWebsite = {
                            // Poin 21: Ganti ke website prodi
                            val browserIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://ti.ummi.ac.id")
                            )
                            startActivity(browserIntent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HasilRegistrasiScreen(
    nama: String,
    nim: String,
    prodi: String,
    email: String,
    telepon: String,
    onOpenWebsite: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Hasil Registrasi Seminar",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Nama : $nama")
        Text(text = "NIM : $nim")
        Text(text = "Prodi : $prodi")
        Text(text = "Email : $email")
        Text(text = "Telepon : $telepon")

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onOpenWebsite,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buka Website Prodi")
        }
    }
}