package com.example.medicoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Configuração padrão de bordas do Android (Mantenha fora do clique)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // --- O CÓDIGO DO BOTÃO DEVE FICAR AQUI, FORA DO LISTENER ACIMA ---
        val btnComecar = findViewById<Button>(R.id.btnComecar)

        btnComecar.setOnClickListener {
            // Agora o 'this' refere-se à MainActivity corretamente
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}